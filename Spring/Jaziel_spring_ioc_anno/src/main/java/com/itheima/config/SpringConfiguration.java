package com.itheima.config;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王杰
 * @time 2020/9/26 20:42
 */
// 指定当前的类是配置类
@Configuration
public class SpringConfiguration {

    @Bean
    public UserServiceImpl userServiceImpl(UserDao userDao){
        return new UserServiceImpl(userDao);
    }

    @Bean
    public UserDao userDaoImpl(){
        return new UserDaoImpl();
    }
}
