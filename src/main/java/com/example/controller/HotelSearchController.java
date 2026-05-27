package com.example.controller;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.SearchHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテル機能のコントローラ.
 *
 * @author takumi kitamura
 */
@Controller
@RequestMapping("/ex02")
public class HotelSearchController {
    @Autowired
    private SearchHotelService service;

    /**
     * 初期表示にフォワードする.
     *
     * @param form  ホテルフォーム
     * @param model リクエストスコープ
     * @return index画面
     */
    @GetMapping("")
    public String index(HotelForm form, Model model) {
        return "ex02/index";
    }

    /**
     * 空文字が来た場合、nullに変換を行う.
     * これによりresult.hasErrorsに空文字が来たときに対応する。
     *
     * @param binder
     */
    @org.springframework.web.bind.annotation.InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    /**
     * 検索結果にフォワードする.
     *
     * @param hotelForm フォーム
     * @param result    バリデーションの結果
     * @param model     リクエストスコープ
     * @return 検索結果画面
     */
    @PostMapping("/search")
    public String search(@Validated HotelForm hotelForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return index(hotelForm, model);
        }

        Hotel hotel = new Hotel();
        hotel.setPrice(hotelForm.getIntPrice());
        Integer hotelPrice = hotel.getPrice();
        List<Hotel> hotels;
        hotels = service.searchByLessThanPrice(hotelPrice);

        if (hotels.isEmpty()) {
            model.addAttribute("message", hotelPrice + "円以下のホテル情報は存在しません");
        }
        model.addAttribute("hotels", hotels);
        return "ex02/index";
    }
}
