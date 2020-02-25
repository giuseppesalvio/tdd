package com.arca.poc.repository;

import com.arca.poc.entity.ContoCorrente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public ContoCorrente getTotaleContoPerAccount(String id) {

      return  jdbcTemplate.queryForObject("select * from contoCorrente  where id=?", new Object[] {id
    },
                new BeanPropertyRowMapper<>(ContoCorrente.class));

    }
}
