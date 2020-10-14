package com.Jaziel.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author 王杰
 * @time 2020/9/26 20:55
 */
//<context:property-placeholder location="classpath:jdbc.properties"/> 加载外部的配置文件
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfigration {
    @Value("${jdbc.driver}")
    private String driver;
    // spring 会将当前结果的返回值存储到 spring 容器中
    @Bean("dataSource")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo_01?characterEncoding=utf-8&characterEncoding=utf-8&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("wedzbze74");
        return dataSource;
    }
}
