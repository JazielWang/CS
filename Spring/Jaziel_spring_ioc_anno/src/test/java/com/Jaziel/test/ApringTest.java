package com.Jaziel.test;

import com.Jaziel.Service.impl.userServiceImpl;
import com.Jaziel.config.SpringConfigration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.security.Provider;
import java.sql.SQLException;

/**
 * @author 王杰
 * @time 2020/9/28 17:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfigration.class})
public class ApringTest {
    @Autowired
    private userServiceImpl userService;
    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
