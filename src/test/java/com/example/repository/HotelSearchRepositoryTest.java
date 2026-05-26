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
}
