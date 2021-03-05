package com.Jaziel.service.imp;

import com.Jaziel.domain.Account;
import com.Jaziel.mapper.AccountMapper;
import com.Jaziel.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/29 19:40
 */
@Service("accountService")
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }

    @Override
    public List<Account> list() {
        return accountMapper.list();
    }
}
