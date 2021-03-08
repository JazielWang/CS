package com.Jaziel.test;

import com.Jaziel.Service.impl.userServiceImpl;
import com.Jaziel.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 王杰
 * @time 2020/9/28 17:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringTest {
    @Autowired
    private userServiceImpl userService;

    @Test
    public void test() throws SQLException {
        userService.save();

    }
}
