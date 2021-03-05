package com.Jaziel.mapper;

import com.Jaziel.domain.User;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/27 14:20
 */
public interface UserMapper {
    void save(User user);

    User findById(int id);

    List<User> findAll();
}
