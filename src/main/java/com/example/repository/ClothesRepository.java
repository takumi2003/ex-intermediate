package com.example.repository;

import com.example.domain.Clothes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 衣類の操作を行う.
 *
 * @author takumi kitamura
 */
@Repository
public class ClothesRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private static final RowMapper<Clothes> ROW_MAPPER = new BeanPropertyRowMapper<>(Clothes.class);

    /**
     * 衣類の全件取得を行う.
     *
     * @return 衣類の全件データ
     */
    public List<Clothes> findAll() {
        String sql = """
                SELECT id,category,genre, gender,color,price,size
                FROM clothes
                ORDER BY id
                """;

        return template.query(sql, ROW_MAPPER);
    }

    /**
     * 性別と色が一致しているものの衣類データを取得する.
     *
     * @param gender 性別
     * @param color  色
     * @return 衣類のデータ
     */
    public List<Clothes> findByGenderAndColor(Integer gender, String color) {
        String sql = """
                SELECT id,category,genre,gender,color,price,size
                FROM clothes
                WHERE gender = :gender AND color = :color
                ORDER BY id
                ;
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("gender", gender)
                .addValue("color", color);
        return template.query(sql, param, ROW_MAPPER);
    }
}
