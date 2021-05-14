package com.Jaziel.test;

import com.Jaziel.POJO.Customer;
import com.Jaziel.POJO.LinkMan;
import com.Jaziel.dao.CustomerDao;
import com.Jaziel.dao.LinkManDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 王杰
 * @date 2021/5/3 13:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-datajpa.xml")
public class OneToMany {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd1() {
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();
        customer.setName("百度");
        linkMan.setName("jack");
        customer.getLinkManSet().add(linkMan);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd2() {
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();
        customer.setName("百度");
        linkMan.setName("jack");
        linkMan.setCustomer(customer);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    public void testAdd3() {
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();
        customer.setName("百度");
        linkMan.setName("jack");
        linkMan.setCustomer(customer);
        customer.getLinkManSet().add(linkMan);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCas() {
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();
        customer.setName("百度");
        linkMan.setName("jack");
        linkMan.setCustomer(customer);
        customer.getLinkManSet().add(linkMan);
        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCas2() {
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();
        customer.setName("百度");
        linkMan.setName("jack");
        linkMan.setCustomer(customer);
        customer.getLinkManSet().add(linkMan);
        customerDao.delete(6L);
    }
}
