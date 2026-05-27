package com.example.repository;

import com.example.domain.baseballTeam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class BaseballTeamRepositoryTest {
    @Autowired
    private BaseballTeamRepository ex01Repository;

    @Test
    void findAllで全てのデータが取得されている() {
        List<baseballTeam> teams = ex01Repository.findAll();
        assertEquals(6, teams.size(), "findAllの取得件数が間違っています");
    }

    @Test
    void findByIDで特定のidのデータを取得する() {
        baseballTeam team = ex01Repository.findById(1);

        assertEquals("読売ジャイアンツ", team.getTeamName(), "findByIDでチーム名が違います");
    }
}