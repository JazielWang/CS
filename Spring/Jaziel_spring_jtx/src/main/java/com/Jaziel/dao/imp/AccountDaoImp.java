package com.Jaziel.dao.imp;

import com.Jaziel.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 王杰
 * @time 2020/10/4 12:51
 */
public class AccountDaoImp implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public AccountDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AccountDaoImp() {

    }

    @Override
    public void in(String inMan, int money) {
        jdbcTemplate.update("update account set money=money-? where name=?", money, inMan);
    }

    @Override
    public void out(String outMan, int money) {
        jdbcTemplate.update("update account set money=money+? where name=?", money, outMan);
    }
}
