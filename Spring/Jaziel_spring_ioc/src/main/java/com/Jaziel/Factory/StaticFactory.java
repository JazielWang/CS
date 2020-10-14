package com.Jaziel.Factory;

import com.Jaziel.dao.Imp.UserDao;
import com.Jaziel.dao.UseDaoImp;

/**
 * @author 王杰
 * @time 2020/9/21 18:48
 */
public class StaticFactory {
    public static UseDaoImp getUserDao(){
        return new UserDao();
    }
}
