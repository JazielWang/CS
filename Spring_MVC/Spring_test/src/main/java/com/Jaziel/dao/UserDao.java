package com.Jaziel.dao;

import com.Jaziel.domain.User;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/17 19:51
 */
public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveIDByRel(Long id, Long[] roleIDs);

    void delUserRoleRel(Long userId);

    void del(Long userId);

    User loginByUsernameAndePassword(String username, String password);
}
