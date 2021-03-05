package com.Jaziel.Service.impl;

import com.Jaziel.Dao.Imp.UserDao;
import com.Jaziel.Service.UserService;

/**
 * @author 王杰
 * @time 2020/9/21 19:23
 */
class UserServiceImpl implements UserService {

    private UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public void save() {
        userDao.save();
    }
}
