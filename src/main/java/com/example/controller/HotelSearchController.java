package com.example.controller;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ex02")
public class HotelSearchController {
    @Autowired
    private HotelSearchService service;

    @GetMapping("")
    public String index(HotelForm form, Model model) {
        return "ex02/index";
    }

    @PostMapping("/search")
    public String search(HotelForm hotelForm, Model model) {
        Hotel hotel = new Hotel();
        hotel.setPrice(hotelForm.getIntPrice());
        List<Hotel> hotels = service.findByPriceLessThanEqual(hotel.getPrice());
        model.addAttribute("hotels", hotels);
        return "ex02/index";
    }
}
