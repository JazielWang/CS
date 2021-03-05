package com.Jaziel.Dao;

import com.Jaziel.Dao.Imp.UserDao;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/14 13:08
 */
public class VO {
    private List<UserDao> userList;

    public List<UserDao> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDao> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }
}
