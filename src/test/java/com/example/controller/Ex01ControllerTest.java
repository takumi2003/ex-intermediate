package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(Ex01Controller.class)
class Ex01ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void デフォルトページとしてindexhtmlを表示する() {
        try {
            mockMvc.perform(get("/ex01"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("/ex01/index"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}