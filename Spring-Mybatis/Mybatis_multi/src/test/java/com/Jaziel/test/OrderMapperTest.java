package com.Jaziel.test;

import com.Jaziel.domain.Order;
import com.Jaziel.domain.Role;
import com.Jaziel.domain.User;
import com.Jaziel.mapper.OrderMapper;
import com.Jaziel.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/27 18:25
 */
public class OrderMapperTest {
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> roleList = mapper.listAll();
        for (User r : roleList){
            System.out.println(r);
        }

        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> all = mapper.findAll();
        for (User u : all){
            System.out.println(u);
        }

        sqlSession.close();
    }

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> all = mapper.findAll();
        for (Order o : all){
            System.out.println(o);
        }

        sqlSession.close();
    }
}
