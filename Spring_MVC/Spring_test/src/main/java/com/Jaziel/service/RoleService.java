package com.Jaziel.service;

import com.Jaziel.domain.Role;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/17 13:58
 */
public interface RoleService {
    public List<Role> list();

    void save(Role role);
}
