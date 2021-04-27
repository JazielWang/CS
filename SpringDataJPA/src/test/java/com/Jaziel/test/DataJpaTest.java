package com.Jaziel.test;

import com.Jaziel.POJO.Customer;
import org.junit.Test;

import javax.persistence.*;

/**
 * @author 王杰
 * @date 2021/4/27 21:00
 */
public class DataJpaTest {
    @Test
    public void saveTest(){
        /**
         * 创建实体管理类工厂，借助Persistence的静态方法获取
         *         其中传递的参数为持久化单元名称，需要jpa配置文件中指定
         */
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");
        //创建实体管理类
        EntityManager entityManager = factory.createEntityManager();
        // 获取事务，并开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 保存操作
        Customer cus = new Customer();
        cus.setName("历史");
        entityManager.persist(cus);
        // 提交事务
        transaction.commit();
        //释放资源
        entityManager.close();
        factory.close();
    }
}
