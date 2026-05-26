package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ex01の課題を行うためのコントローラクラス
 *
 * @author takumi kitamura
 */
@Controller
@RequestMapping("/ex01")
public class Ex01Controller {
    @GetMapping("")
    public String index() {
        return "/ex01/index";
    }


}
