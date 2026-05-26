package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelSearchRepository {
    @Autowired
    private NamedParameterJdbcTemplate param;

    private static final RowMapper<Hotel> ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

    public List<Hotel> getAll() {
        String sql = """
                SELECT id,area_name,hotel_name,address,nearest_station,price,parking
                FROM hotels
                ;
                """;

        return param.query(sql, ROW_MAPPER);
    }

    public List<Hotel> findByPriceLessThanEqual(int i) {
        String sql = """
                SELECT id,area_name,hotel_name,address,nearest_station,price,parking
                FROM hotels
                WHERE price <= 10000
                ;
                """;
        return param.query(sql, ROW_MAPPER);
    }
}
