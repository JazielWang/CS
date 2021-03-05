package com.Jaziel.mapper;

import com.Jaziel.domain.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/29 19:37
 */

public interface AccountMapper {

    void save(Account account);

    List<Account> list();
}
