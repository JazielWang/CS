package com.Jaziel.test;

import com.Jaziel.POJO.Customer;
import com.Jaziel.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author 王杰
 * @date 2021/5/3 11:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-datajpa.xml")
public class SpecTest {
    @Autowired
    CustomerDao customerDao;

    @Test
    public void testSpec() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Predicate wj = criteriaBuilder.equal(name, "wj");
                return wj;
            }
        };

        List<Customer> all = customerDao.findAll(specification);
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    @Test
    public void testSpec2() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Predicate wj = criteriaBuilder.like(name.as(String.class), "w%");
                return wj;
            }
        };

        List<Customer> all = customerDao.findAll(specification);
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    @Test
    public void testSpec3() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Predicate wj = criteriaBuilder.like(name.as(String.class), "w%");
                return wj;
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        List<Customer> all = customerDao.findAll(specification, sort);
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    @Test
    public void testSpec4() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Path<Object> id = root.get("id");
                Predicate wj = criteriaBuilder.like(name.as(String.class), "w%");
                Predicate equal = criteriaBuilder.equal(id, 3L);
                return criteriaBuilder.and(wj, equal);
            }
        };
        Customer one = customerDao.findOne(specification);
        System.out.println(one);
    }

    @Test
    public void testSpec5() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Predicate wj = criteriaBuilder.like(name.as(String.class), "w%");
                return wj;
            }
        };
        Pageable pageable = new PageRequest(0, 2);
        Page<Customer> all = customerDao.findAll(specification, pageable);
        System.out.println(all.getContent());
        System.out.println(all.getTotalElements());
        System.out.println(all.getTotalPages());
    }
}
