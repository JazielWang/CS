package com.Jaziel.test;

import com.Jaziel.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/23 17:48
 */
public class MybatisTest {
    @Test
    public void test4() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得 session 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得 session 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace + id
        sqlSession.delete("userMapper.delete",2);
        // mybatis 默认是不改变数据的，需要提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setId(2);
        user.setUsername("jerry");
        user.setPassword("abc");
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得 session 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得 session 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace + id
        sqlSession.update("userMapper.update",user);
        // mybatis 默认是不改变数据的，需要提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得 session 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得 session 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 执行操作 参数：namespace + id
        sqlSession.insert("userMapper.save", user);
        /*// mybatis 默认是不改变数据的，需要提交事务
        sqlSession.commit();*/
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void test1() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得 session 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得 session 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace + id
        List<User> objects = sqlSession.selectList("userMapper.findAll");
        // 打印数据
        System.out.println(objects);
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得 session 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得 session 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace + id
        User user = sqlSession.selectOne("userMapper.findById", 1);
        // 打印数据
        System.out.println(user);
        // 释放资源
        sqlSession.close();
    }
}
