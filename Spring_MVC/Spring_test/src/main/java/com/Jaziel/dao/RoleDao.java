package com.Jaziel.dao;

import com.Jaziel.domain.Role;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/17 14:05
 */
public interface RoleDao {

    List<Role> findAll();

    void save(Role role);

    List<Role> getNameById(long id);
}
