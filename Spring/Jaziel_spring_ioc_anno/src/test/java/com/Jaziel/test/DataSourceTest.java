package com.Jaziel.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author 王杰
 * @time 2020/9/25 17:34
 */
public class DataSourceTest {
    @Test
    /*使用 spring 容器创建数据源*/
    public void test4() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dateSource = (DataSource) app.getBean("dateSource");
        Connection connection = dateSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
    @Test
    /*手动创建 c3p0 数据源 （导入配置文件版,配置文件在source下建立）*/
    public void test3() throws PropertyVetoException, SQLException {
        // 读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(rb.getString("jdbc.driver"));
        dataSource.setJdbcUrl(rb.getString("jdbc.url"));
        dataSource.setUser(rb.getString("jdbc.user"));
        dataSource.setPassword(rb.getString("jdbc.password"));
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    /*手动创建 druid 数据源*/
    public void test2() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/demo_01?characterEncoding=utf-8&characterEncoding=utf-8&serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("wedzbze74");
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    /*手动创建 c3p0 数据源*/
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo_01?characterEncoding=utf-8&characterEncoding=utf-8&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("wedzbze74");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
