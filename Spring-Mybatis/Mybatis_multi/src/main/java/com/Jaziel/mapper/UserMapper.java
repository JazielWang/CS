package com.Jaziel.mapper;

import com.Jaziel.domain.Role;
import com.Jaziel.domain.User;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/25 16:53
 */
public interface UserMapper {
    List<User> findAll();

    List<User> listAll();
}
