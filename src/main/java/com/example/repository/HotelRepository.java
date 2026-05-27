package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ホテル機能のリポジトリ.
 *
 * @author takumi kitamura
 */
@Repository
public class HotelRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Hotel> ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

    /**
     * DBからホテルを全件取得する.
     *
     * @return ホテルの全件
     */
    public List<Hotel> findAll() {
        String sql = """
                SELECT id,area_name,hotel_name,address,nearest_station,price,parking
                FROM hotels
                ;
                """;

        return template.query(sql, ROW_MAPPER);
    }

    /**
     * 特定の値段以下のホテルを取得する.
     *
     * @param price 指定する値段
     * @return 検索結果のホテル
     */
    public List<Hotel> findByPriceLessThanEqual(int price) {
        String sql = """
                SELECT id,area_name,hotel_name,address,nearest_station,price,parking
                FROM hotels
                WHERE price <= :price
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("price", price);
        return template.query(sql, param, ROW_MAPPER);
    }
}
