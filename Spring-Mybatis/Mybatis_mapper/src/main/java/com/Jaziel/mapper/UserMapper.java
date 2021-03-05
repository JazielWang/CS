package com.Jaziel.mapper;

import com.Jaziel.domain.User;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/25 16:53
 */
public interface UserMapper {
    /**
     * 根据用户获得用户的集合
     * @param user 用户
     * @return 返回用户的集合
     */
    List<User> findByCondition(User user);

    List<User> findByIds(List<Integer> ids);
}
