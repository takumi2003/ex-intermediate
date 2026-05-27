package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ホテルのサービス.
 *
 * @author takumi kitamura
 */
@Service
public class SearchHotelService {
    @Autowired
    private HotelRepository repository;

    /**
     * リポジトリクラスからホテルを全件取得する.
     *
     * @return ホテルの全件
     */
    public List<Hotel> findAll() {
        return repository.findAll();
    }

    /**
     * リポジトリから特定の値段以下のホテルを取得する.
     *
     * @param price 指定する値段
     * @return 検索結果のホテル
     */
    public List<Hotel> searchByLessThanPrice(Integer price) {
        List<Hotel> hotels;
        if (price == null) {
            hotels = repository.findAll();
        } else {
            hotels = repository.findByPriceLessThanEqual(price);
        }
        return hotels;
    }
}
