package com.Jaziel.test;

import com.Jaziel.POJO.Customer;
import com.Jaziel.POJO.LinkMan;
import com.Jaziel.dao.CustomerDao;
import com.Jaziel.dao.LinkManDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author 王杰
 * @date 2021/5/4 11:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-datajpa.xml")
public class ObjectGuiteTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    public void linkTest(){
        Customer one = customerDao.findOne(5L);
        Set<LinkMan> linkManSet = one.getLinkManSet();
        for (LinkMan linkMan : linkManSet) {
            System.out.println(linkMan);
        }
    }

    @Test
    @Transactional
    public void linkTest2(){
        LinkMan one = linkManDao.findOne(1L);
        Customer customer = one.getCustomer();
        System.out.println(customer);
    }
}
