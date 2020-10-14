package com.Jaziel.dao;

/**
 * @author 王杰
 * @time 2020/10/4 12:51
 */
public interface AccountDao {
    public void in(String name, int money);
    public void out(String name, int money);
}
