package com.Jaziel.service.imp;

import com.Jaziel.dao.RoleDao;
import com.Jaziel.dao.UserDao;
import com.Jaziel.domain.Role;
import com.Jaziel.domain.User;
import com.Jaziel.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/17 19:48
 */
public class UserServiceImp implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        // 封账 userList 中每一个 user 的 role 数据
        for(User user : userList){
            // 获得每一个user 的 id
            Long id = user.getId();
            // 将 id 作为参数传入
            List<Role> roles = roleDao.getNameById(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIDs) {
        // 在 sys_user 保存 user
        Long userID = userDao.save(user);
        // 在 usr_role_sys 保存 roleID
        userDao.saveIDByRel(userID, roleIDs);
    }

    @Override
    public void del(Long userId) {
        //删除 sys_role_user 中的数据
        userDao.delUserRoleRel(userId);
        //删除 sys_user 中的数据
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.loginByUsernameAndePassword(username, password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
