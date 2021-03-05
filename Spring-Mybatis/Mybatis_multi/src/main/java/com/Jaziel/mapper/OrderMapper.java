package com.Jaziel.mapper;

import com.Jaziel.domain.Order;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/27 17:27
 */
public interface OrderMapper {
    List<Order> findAll();

}
