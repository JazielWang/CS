package com.Jaziel.service.imp;

import com.Jaziel.dao.AccountDao;
import com.Jaziel.service.AccountService;

/**
 * @author 王杰
 * @time 2020/10/4 13:04
 */
public class AccountSerivesImp implements AccountService {

    private AccountDao accountDao;

    public AccountSerivesImp(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String inMan, String outMan, int money) {
        accountDao.in(inMan, money);
        /*经过事务控制之后，虽然还是会发生报错，但是钱没有消失
        * 达到了一种 一个方内的操作那个同时进行，成功or失败*/
        int error = 1/0;
        accountDao.out(outMan, money);
    }
}
