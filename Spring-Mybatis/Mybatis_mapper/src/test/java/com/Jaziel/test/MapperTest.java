package com.Jaziel.test;

import com.Jaziel.domain.User;
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
 * @time 2020/10/25 17:01
 */
public class MapperTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        // 模拟condition
        User conditioin = new User();
//        conditioin.setId(1);
        conditioin.setUsername("wj");
        conditioin.setPassword("123");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        /*List<User> byCondition = mapper.findByCondition(conditioin);
        System.out.println(byCondition);*/
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);

        List<User> byIds = mapper.findByIds(ids);
        System.out.println(byIds);
    }
}
