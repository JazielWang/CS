package com.Jaziel.test;

import com.Jaziel.POJO.Customer;
import com.Jaziel.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        // 创建实体管理类
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

    @Test
    public void findTest(){
        EntityManager jpaManager = JpaUtils.getJpaManager();
        EntityTransaction transaction = jpaManager.getTransaction();
        transaction.begin();
        /*find() 和 getReference() 中主要使用 getReference*/
        // Customer customer = jpaManager.find(Customer.class, 1L);
        Customer customer = jpaManager.getReference(Customer.class, 1L);
        System.out.println(customer);
        transaction.commit();
        jpaManager.close();
    }

    @Test
    public void updateTest(){
        EntityManager jpaManager = null;
        EntityTransaction transaction = null;
        try {
            jpaManager = JpaUtils.getJpaManager();
            transaction = jpaManager.getTransaction();
            transaction.begin();
            Customer customer = jpaManager.find(Customer.class, 1L);
            customer.setName("lj");
            // 把c1对象从缓存中清除出去
            jpaManager.clear();
            jpaManager.merge(customer);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            jpaManager.close();
        }
    }

    @Test
    public void deleteTest(){
        EntityManager jpaManager = null;
        EntityTransaction transaction = null;
        try {
            jpaManager = JpaUtils.getJpaManager();
            transaction = jpaManager.getTransaction();
            transaction.begin();
            Customer customer = jpaManager.find(Customer.class, 1L);
            jpaManager.remove(customer);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            jpaManager.close();
        }
    }
}
