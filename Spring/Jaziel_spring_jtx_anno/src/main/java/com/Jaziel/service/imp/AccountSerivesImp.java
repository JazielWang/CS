package com.Jaziel.service.imp;

import com.Jaziel.dao.AccountDao;
import com.Jaziel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 王杰
 * @time 2020/10/4 13:04
 */
@Service("accountService")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class AccountSerivesImp implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    /*当在类上和方法上都存在 Transaction 注释，起作用的是位于方法上的注释*/
    @Transactional(isolation = Isolation.DEFAULT)
    public void transfer(String inMan, String outMan, int money) {
        accountDao.in(inMan, money);
        /*经过事务控制之后，虽然还是会发生报错，但是钱没有消失
        * 达到了一种 一个方内的操作那个同时进行，成功or失败*/
        int error = 1/0;
        accountDao.out(outMan, money);
    }
}
