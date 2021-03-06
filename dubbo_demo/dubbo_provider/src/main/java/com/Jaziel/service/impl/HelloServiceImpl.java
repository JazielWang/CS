package com.Jaziel.service.impl;

import com.Jaziel.service.HelloService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author 王杰
 * @date 2021/3/6 12:32
 */

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
