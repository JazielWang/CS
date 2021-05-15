package com.Jaziel.mapper;

import com.Jaziel.pojo.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author 王杰
 * @time 2020/11/4 17:10
 */
@Component(value = "userMapper")
public interface UserMapper extends Mapper<User> {

}
