package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HotelSearchController.class)
public class HotelSearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void デフォルトページとしてindexhtmlを表示する() {
        try {
            mockMvc.perform(get("/ex02"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("/ex02/index"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
