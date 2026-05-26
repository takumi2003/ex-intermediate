package com.example.repository;

import com.example.domain.baseballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Ex01のリポジトリクラス.
 *
 * @author takumi kitamura
 */
@Repository
public class Ex01Repository {
    private static final RowMapper<baseballTeam> ROW_MAPPER = new BeanPropertyRowMapper<>(baseballTeam.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 全件検索を行う.
     *
     * @return 野球チームデータのリスト
     */
    public List<baseballTeam> findAll() {
        String sql = """
                SELECT league_name,team_name,headquarters,inauguration,history
                FROM teams
                ORDER BY headquarters
                ;
                """;
        return template.query(sql, ROW_MAPPER);
    }

    /**
     * 特定のidに紐ずくデータを取得する.
     *
     * @param id
     * @return idに紐ずく野球チームデータ
     */
    public baseballTeam findById(int id) {
        String sql = """
                SELECT league_name,team_name,headquarters,inauguration,history
                FROM teams
                WHERE id = :id
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, param, ROW_MAPPER);
    }
}
