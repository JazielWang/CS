package com.Jaziel.test;

import com.Jaziel.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/3 16:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateUDRI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testQuarryCount(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }

    @Test
    public void testQuarryOne(){
        Account query = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class),"Dog");
        System.out.println(query);
    }

    @Test
    public void testQuarryAll(){
        List<Account> query = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?", 10000, "Tom");
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name=?", "Tom");
    }
}
