package com.Jaziel.test;

import Jaziel.domain.Order;
import Jaziel.domain.User;
import Jaziel.mapper.OrderMapper;
import Jaziel.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/28 19:39
 */
public class MybatisTest2 {

    private OrderMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);
    }


    @Test
    public void testSave(){
        List<Order> orders = mapper.finaAll();
        for (Order o : orders){
            System.out.println(o);
        }
    }
}
