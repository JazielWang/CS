package com.Jaziel.test;


import com.Jaziel.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王杰
 * @time 2020/10/2 13:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class annoTest {
    @Autowired
    private TargetInterface target;

    @Test
    public void test(){
        target.save();
    }
}
