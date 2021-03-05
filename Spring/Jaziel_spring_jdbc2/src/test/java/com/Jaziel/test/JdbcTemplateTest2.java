package com.Jaziel.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.beans.PropertyVetoException;

/**
 * @author 王杰
 * @time 2020/10/2 19:04
 */
public class JdbcTemplateTest2 {
    @Test
    // 使用 spring 框架自动生成 JdbcTempla 对象
    public void test2() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int jerry = jdbcTemplate.update("insert into account value (?,?)", "Dog", 5000);
        System.out.println(jerry);
    }
    @Test
    // 测试 jdbcTempla 开发步骤
    public void test1() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo_01?characterEncoding=utf-8&characterEncoding=utf-8&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("wedzbze74");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        int tom = jdbcTemplate.update("insert into account value (?,?)", "Tom", 5000);
        System.out.println(tom);
    }
}
