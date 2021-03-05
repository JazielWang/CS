package com.Jaziel.test;

import com.Jaziel.dao.Imp.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 王杰
 * @time 2020/9/21 16:54
 */
public class SpringTest {
    @Test
    public void Test1(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userdao1 = (UserDao) app.getBean("userDao");
        System.out.println(userdao1);
    }
}
