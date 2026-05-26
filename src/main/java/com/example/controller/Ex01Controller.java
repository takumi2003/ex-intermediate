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
 * Ex01の課題を行うためのコントローラクラス
 *
 * @author takumi kitamura
 */
@Controller
@RequestMapping("/ex01")
public class Ex01Controller {
    @Autowired
    private Ex01Service service;

    @GetMapping("")
    public String index(baseballTeam baseballTeam, Model model) {
        List<baseballTeam> teams = service.findAll();
        model.addAttribute("teams", teams);
        return "/ex01/index";
    }

    @GetMapping("detail")
    public String detail(Integer id, Model model) {
        baseballTeam team = service.findById(id);
        model.addAttribute("team", team);
        return "/ex01/detail";
    }


}
