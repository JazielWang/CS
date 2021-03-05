package com.Jaziel.test;

import com.Jaziel.aop.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王杰
 * @time 2020/9/30 20:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyRespectTest {

    @Autowired
    private TargetInterface targetInterface;

    @Test
    public void test(){
        targetInterface.save();
    }
}
