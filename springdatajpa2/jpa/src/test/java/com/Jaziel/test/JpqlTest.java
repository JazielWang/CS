package com.Jaziel.test;

import com.Jaziel.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @author 王杰
 * @date 2021/4/29 17:18
 */
public class JpqlTest {
    @Test
    public void findAllTest() {
        EntityManager jpaManager = null;
        EntityTransaction transaction = null;
        try {
            jpaManager = JpaUtils.getJpaManager();
            transaction = jpaManager.getTransaction();
            transaction.begin();
            Query query = jpaManager.createQuery("from Customer");
            List resultList = query.getResultList();
            for (Object o : resultList) {
                System.out.println(o);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            assert jpaManager != null;
            jpaManager.close();
        }
    }

    @Test
    public void pagesTest() {
        EntityManager jpaManager = null;
        EntityTransaction transaction = null;
        try {
            jpaManager = JpaUtils.getJpaManager();
            transaction = jpaManager.getTransaction();
            transaction.begin();
            Query query = jpaManager.createQuery("from Customer");
            query.setFirstResult(0);
            query.setMaxResults(2);
            List resultList = query.getResultList();
            for (Object o : resultList) {
                System.out.println(o);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            jpaManager.close();
        }
    }

    @Test
    public void conditionTest() {
        EntityManager jpaManager = null;
        EntityTransaction transaction = null;
        try {
            jpaManager = JpaUtils.getJpaManager();
            transaction = jpaManager.getTransaction();
            transaction.begin();
            Query query = jpaManager.createQuery("from Customer where cust_name like ?1");
            query.setParameter(1, "wj%");
            System.out.println(query.getSingleResult());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            jpaManager.close();
        }
    }

    @Test
    public void orderTest() {
        EntityManager jpaManager = null;
        EntityTransaction transaction = null;
        try {
            jpaManager = JpaUtils.getJpaManager();
            transaction = jpaManager.getTransaction();
            transaction.begin();
            Query query = jpaManager.createQuery("from Customer order by cust_id desc");
            List resultList = query.getResultList();
            for (Object o : resultList) {
                System.out.println(o);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            jpaManager.close();
        }
    }

    @Test
    public void countTest() {
        EntityManager jpaManager = null;
        EntityTransaction transaction = null;
        try {
            jpaManager = JpaUtils.getJpaManager();
            transaction = jpaManager.getTransaction();
            transaction.begin();
            Query query = jpaManager.createQuery("select count(cust_id) from Customer");
            System.out.println(query.getSingleResult());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            jpaManager.close();
        }
    }
}
