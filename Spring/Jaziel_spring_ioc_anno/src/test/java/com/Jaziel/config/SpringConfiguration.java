package com.Jaziel.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author 王杰
 * @time 2020/9/26 20:42
 */
// 指定当前的类是配置类
@Configuration
//<context:component-scan base-package="com.Jaziel"/> 组件扫描
@ComponentScan("com.Jaziel")
// <import resource=""> 引入其他配置文件（分模块管理）
@Import({DataSourceConfigration.class})
public class SpringConfiguration {

}
