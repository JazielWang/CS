package com.Jaziel.service.imp;

import com.Jaziel.dao.RoleDao;
import com.Jaziel.domain.Role;
import com.Jaziel.service.RoleService;


import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/17 13:59
 */
public class roleServiceImp implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
