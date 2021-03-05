package com.Jaziel.service;

import com.Jaziel.domain.User;

import java.awt.*;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/17 19:46
 */
public interface UserService {

    List<User> list();

    void save(User user, Long[] roleIDs);

    void del(Long userId);

    User login(String username, String password);
}
