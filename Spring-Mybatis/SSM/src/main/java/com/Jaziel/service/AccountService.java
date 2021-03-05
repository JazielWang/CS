package com.Jaziel.service;

import com.Jaziel.domain.Account;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/29 19:39
 */
public interface AccountService {

    void save(Account account);
    List<Account> list();
}
