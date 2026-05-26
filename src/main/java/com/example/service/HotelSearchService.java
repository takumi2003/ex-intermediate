package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelSearchService {
    @Autowired
    private HotelSearchRepository repository;

    public List<Hotel> getAll() {
        return repository.getAll();
    }

    public List<Hotel> findByPriceLessThanEqual(int price) {
        return repository.findByPriceLessThanEqual(price);
    }

}
