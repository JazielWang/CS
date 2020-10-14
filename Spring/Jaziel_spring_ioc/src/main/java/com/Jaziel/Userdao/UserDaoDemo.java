package com.Jaziel.Userdao;

import com.Jaziel.dao.Imp.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 王杰
 * @time 2020/9/20 17:34
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userdao = (UserDao) app.getBean("userDao");
        userdao.save();
    }
}
