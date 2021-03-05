package com.Jaziel.dao;

import com.Jaziel.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/25 15:24
 */
public interface DaoMapper {
    List<User> findAll() throws IOException;
    User findById(int id);
}
