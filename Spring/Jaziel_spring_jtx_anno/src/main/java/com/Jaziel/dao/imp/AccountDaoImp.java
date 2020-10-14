package com.Jaziel.dao.imp;

import com.Jaziel.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.beans.ConstructorProperties;

/**
 * @author 王杰
 * @time 2020/10/4 12:51
 */
@Repository("accountDao")
public class AccountDaoImp implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
