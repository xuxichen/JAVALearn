package com.jedis.dao.impl;

import com.jedis.dao.ProvinceDao;
import com.jedis.domain.Province;
import com.jedis.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> finAll() {
        String sql = "SELECT * FROM province";
        try {
            List<Province> provinces = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
            return provinces;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
