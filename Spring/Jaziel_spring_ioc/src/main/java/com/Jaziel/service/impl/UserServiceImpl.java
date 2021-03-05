package com.Jaziel.service.impl;

import com.Jaziel.dao.Imp.UserDao;
import com.Jaziel.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 王杰
 * @time 2020/9/21 19:23
 */
class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 构造方法注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // set 方法注入
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public void save() {
        /*ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");*/
        userDao.save();
    }
}
