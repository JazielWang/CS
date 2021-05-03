package com.Jaziel.test;

import com.Jaziel.dao.SysRoleDao;
import com.Jaziel.dao.SysUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王杰
 * @date 2021/5/3 20:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-datajpa.xml")
public class ManyToManyTest {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;

    @Test
    public void saveTest(){

    }
}
