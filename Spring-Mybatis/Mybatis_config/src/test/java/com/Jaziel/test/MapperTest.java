package com.Jaziel.test;

import com.Jaziel.domain.User;
import com.Jaziel.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/27 14:21
 */
public class MapperTest {
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 设置分页相关参数：第几页+每页内容
        PageHelper.startPage(1, 2);

        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        // 获得分页相关参数
        PageInfo<User> pageInfo = new PageInfo<>(all);
        System.out.println("当前页" + pageInfo.getPageNum());
        System.out.println("每页显示条数" + pageInfo.getPageSize());
        System.out.println("总条数" + pageInfo.getTotal());
        System.out.println("总页数" + pageInfo.getPages());
        System.out.println("上一页" + pageInfo.getPrePage());
        System.out.println("下一页" + pageInfo.getNextPage());
        System.out.println("是否是首页" + pageInfo.isIsFirstPage());
        System.out.println("是否是尾页" + pageInfo.isIsLastPage());

        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User byId = mapper.findById(4);
        System.out.println(byId.getBirthday());

        sqlSession.close();
    }

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        // 模拟 user
        User user = new User();
        user.setId(5);
        user.setUsername("dqy");
        user.setPassword("123");
        user.setBirthday(new Date());

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.save(user);
        sqlSession.close();
    }
}
