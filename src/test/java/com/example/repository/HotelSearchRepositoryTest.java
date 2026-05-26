package com.example.repository;

import com.example.domain.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class HotelSearchRepositoryTest {
    @Autowired
    private HotelSearchRepository repository;

    @Test
    void ホテルを全件取得する() {
        List<Hotel> hotels = repository.getAll();
        assertEquals(5, hotels.size(), "getAllを用いて取得した数と異なります");
    }

    @Test
    void 指定された金額以下のホテルを取得する() {
        List<Hotel> hotels = repository.findByPriceLessThanEqual(10000);
        assertEquals(3, hotels.size(), "10000円以下のホテルを取得した数が間違っています。");
    }
}
