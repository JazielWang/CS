package com.Jaziel.service;

import com.Jaziel.mapper.UserMapper;
import com.Jaziel.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 王杰
 * @time 2020/11/4 19:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getById() {
        userMapper.selectByPrimaryKey(8);
    }

    @Test
    void save() {
        User user = new User();
        user.setUserName("wj");
        user.setAge(12);
        user.setPassword("lj");
        user.setCreated(new Date());
        userMapper.insertSelective(user);
    }
}