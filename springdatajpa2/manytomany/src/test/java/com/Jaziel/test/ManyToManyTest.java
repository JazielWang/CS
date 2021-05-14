package com.Jaziel.test;

import com.Jaziel.POJO.SysRole;
import com.Jaziel.POJO.SysUser;
import com.Jaziel.dao.SysRoleDao;
import com.Jaziel.dao.SysUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Rollback(value = false)
    public void saveTest(){
        SysUser user = new SysUser();
        user.setUsername("小王");
        SysRole role = new SysRole();
        role.setRoleName("admin");

        // 配置角色对用户的关系
        user.getRoles().add(role);

        sysRoleDao.save(role);
        sysUserDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveTest2(){
        SysUser user = new SysUser();
        user.setUsername("小李");
        SysRole role = new SysRole();
        role.setRoleName("user");

        // 配置角色对用户的关系
        user.getRoles().add(role);
        // 放弃SysRole的主键维护权之后，不在报错
        role.getUsers().add(user);

        sysRoleDao.save(role);
        sysUserDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveTest3(){
        SysUser user = new SysUser();
        user.setUsername("小李");
        SysRole role = new SysRole();
        role.setRoleName("user");

        // 配置角色对用户的关系
        user.getRoles().add(role);
        // 放弃SysRole的主键维护权之后，不在报错
        role.getUsers().add(user);

        sysRoleDao.save(role);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void descTest(){
        sysUserDao.delete(9L);
    }
}


