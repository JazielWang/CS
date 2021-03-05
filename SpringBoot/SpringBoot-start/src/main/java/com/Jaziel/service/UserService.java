package com.Jaziel.service;

import com.Jaziel.mapper.UserMapper;
import com.Jaziel.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/11/4 17:21
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 查询
    public List<User> list(){
        return userMapper.selectAll();
    }

    // 根据 id 查询
    public User getById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    // 保存用户
    @Transactional
    public void save(User user){
        System.out.println("保存成功");
        userMapper.insertSelective(user);
    }
}
