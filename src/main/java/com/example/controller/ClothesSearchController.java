package com.example.controller;

import com.example.domain.Clothes;
import com.example.form.ClothesForm;
import com.example.service.SearchClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 衣類を検索するコントローラ.
 *
 * @author takumi kitamura
 */
@Controller
@RequestMapping("/ex03")
public class ClothesSearchController {

    @Autowired
    private SearchClothesService service;

    /**
     * トップ画面にフォワードする.
     *
     * @param form フォーム
     * @param model リクエストスコープ
     * @return トップ画面
     */
    @GetMapping("")
    public String index(ClothesForm form, Model model) {
        return "ex03/index";
    }

    /**
     * 検索を行い、トップ画面にフォワードする.
     *
     * @param form フォーム
     * @param result リザルト
     * @param model リクエストスコープ
     * @return トップ画面
     */
    @PostMapping("/search")
    public String search(@Validated ClothesForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return index(form, model);
        }
        List<Clothes> clothes = service.getGenderAndColorClothes(form.getIntegerGender(), form.getColor());
        if (clothes.isEmpty()) {
            model.addAttribute("message", true);
        }
        model.addAttribute("clothes", clothes);
        return "ex03/index";
    }

}
