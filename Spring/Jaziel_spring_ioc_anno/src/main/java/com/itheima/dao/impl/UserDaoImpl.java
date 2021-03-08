package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * @author 王杰
 * @date 2021/3/8 15:10
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
