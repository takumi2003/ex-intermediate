package com.example.controller;

import com.example.domain.baseballTeam;
import com.example.service.Ex01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Ex01の課題を行うためのコントローラクラス.
 *
 * @author takumi kitamura
 */
@Controller
@RequestMapping("/ex01")
public class Ex01Controller {
    @Autowired
    private Ex01Service service;

    /**
     * デフォルトのページにフォワード.
     *
     * @param model リクエストスコープ
     * @return データが存在する時、index.htmlを表示
     * @return データが存在しない時、error.htmlを表示
     */
    @GetMapping("")
    public String index(Model model) {
        List<baseballTeam> teams = service.findAll();
        if(teams.isEmpty()){
            return "/ex01/error";
        }
        model.addAttribute("teams", teams);
        return "/ex01/index";
    }

    /**
     * それぞれの詳細ページを表示するためのフォワード.
     *
     * @param id 選択したurlに紐ずくid
     * @param model リクエストスコープ
     * @return 詳細ページのhtmlを表示
     */
    @GetMapping("detail")
    public String detail(Integer id, Model model) {
        baseballTeam team = service.findById(id);
        model.addAttribute("team", team);
        return "/ex01/detail";
    }


}
