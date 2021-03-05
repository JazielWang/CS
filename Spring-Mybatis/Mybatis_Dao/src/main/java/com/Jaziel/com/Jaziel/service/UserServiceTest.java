package com.Jaziel.com.Jaziel.service;

import com.Jaziel.dao.DaoMapper;
import com.Jaziel.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/25 15:35
 */
public class UserServiceTest {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        DaoMapper mapper = sqlSession.getMapper(DaoMapper.class);

        List<User> all = mapper.findAll();
        User byId = mapper.findById(1);
        System.out.println(byId);
        System.out.println(all);
    }
}
