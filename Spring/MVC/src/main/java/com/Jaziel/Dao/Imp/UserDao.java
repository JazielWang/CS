package com.Jaziel.Dao.Imp;

import com.Jaziel.Dao.UseDaoImp;

/**
 * @author 王杰
 * @time 2020/9/20 17:29
 */
public class UserDao implements UseDaoImp {

    @Override
    public void save() {
        System.out.println("save running...");
    }
}
