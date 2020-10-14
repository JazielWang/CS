package com.Jaziel.Dao.impl;

import com.Jaziel.Dao.userDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author 王杰
 * @time 2020/9/26 16:15
 */
//<bean id="userDao" class="com.Jaziel.Dao.impl.userDaoImpl"/>
//@Component("userDao")
@Repository("userDao")
public class userDaoImpl implements userDao {

    @Override
    public void save() {
        System.out.println("save running...");
    }
}
