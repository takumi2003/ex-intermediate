package com.example.service;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 衣類の検索を行うサービス.
 *
 * @author takumi kitamura
 */
@Service
@Transactional
public class SearchClothesService {

    @Autowired
    private ClothesRepository repository;

    /**
     * 性別と色が一致しているもののデータを取得する.
     *
     * @param gender 性別
     * @param color  色
     * @return 衣類のデータ
     */
    public List<Clothes> getGenderAndColorClothes(Integer gender, String color) {
        return repository.findByGenderAndColor(gender, color);
    }
}
