package com.Jaziel.Service.impl;

import com.Jaziel.Dao.userDao;
import com.Jaziel.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author 王杰
 * @time 2020/9/26 16:18
 */
// <bean id="userService" class="com.Jaziel.Service.impl.userServiceImpl">
//@Component("userService")
@Service("userService")
public class userServiceImpl implements userService {
    // value 的重要作用
    @Value("${jdbc.driver}")
    private String drive;

    @Autowired // 按照数据类型从 spring 容器中进行匹配，可以不使用@Qualifer
    @Qualifier("userDao") //按照 id 值从容器中进行匹配，需要与 @Autowired 一起使用
    // @Resource = @Autowired + @Qualifier，但是没有用出来！！！
    private userDao userDao;

    public void setUserDao(userDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println(drive);
        userDao.save();
    }

    @PostConstruct
    public void start() {
        System.out.println("初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("初始化方法");
    }
}
