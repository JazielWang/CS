package com.Jaziel.test;

import com.Jaziel.POJO.Customer;
import com.Jaziel.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 王杰
 * @date 2021/5/1 15:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-datajpa.xml")
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void findOne() {
        Customer one = customerDao.findOne(3L);
        System.out.println(one);
    }

    @Test
    public void saveTest() {
        Customer customer = new Customer();
        customer.setId(5L);
        customer.setName("sy");
        customer.setAddress("my");
        customerDao.save(customer);
    }

    @Test
    public void deleteTest() {
        customerDao.delete(5L);
    }

    @Test
    public void findAll() {
        List<Customer> all = customerDao.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    @Test
    public void countTest() {
        long count = customerDao.count();
        System.out.println(count);
    }

    @Test
    public void exTest() {
        boolean exists = customerDao.exists(4L);
        System.out.println(exists);
    }

    @Test
    public void findAllCut() {
        List<Customer> allCustomer = customerDao.findAllCustomer();
        System.out.println(allCustomer);
    }

    @Test
    public void updateTest() {
        Customer customer = customerDao.findCustomer(4L);
        System.out.println(customer);

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void update() {
        customerDao.updateCustomer(3L, "dzr");
    }

    @Test
    public void select(){
        Customer customer = customerDao.selectCustomer(2L);
        System.out.println(customer);
    }

    @Test
    public void findByName(){
        Customer customer = customerDao.findByName("wj");
        System.out.println(customer);
    }

    @Test
    public void findByNameLike(){
        List<Customer> byNameLike = customerDao.findByNameLike("w%");
        for (Customer customer : byNameLike) {
            System.out.println(customer);
        }
    }

    @Test
    public void findByNameLikeAnd(){
        Customer hy = customerDao.findByNameLikeAndAddress("w%", "hy");
        System.out.println(hy);
    }
}
