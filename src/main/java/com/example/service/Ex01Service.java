package com.example.service;

import com.example.domain.baseballTeam;
import com.example.repository.Ex01Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Ex01のサービスクラス.
 *
 * @author takumi kitamura
 */
@Service
public class Ex01Service {
    @Autowired
    private Ex01Repository repository;

    /**
     * 全件検索を行う.
     *
     * @return 全野球チームのデータ
     */
    public List<baseballTeam> findAll() {
        return repository.findAll();
    }

    /**
     * 特定の野球チームの検索を行う.
     *
     * @param id チーム固有のid
     * @return idに紐ずく野球チームのデータ
     */
    public baseballTeam findById(int id) {
        return repository.findById(id);
    }
}
