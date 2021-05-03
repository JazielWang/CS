package com.Jaziel.dao;

import com.Jaziel.POJO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author 王杰
 * @date 2021/5/1 15:34
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    /**
     * 个人定义实现 findAll 方法
     */
    @Query(value = "from Customer ")
    public List<Customer> findAllCustomer();

    @Query(value = "from Customer where id = ?1")
    public Customer findCustomer(Long id);

    @Query(value = "update Customer set name = ?2 where id = ?1")
    @Modifying
    void updateCustomer(Long id, String name);

    @Query(value = "select * from cst_customer where cust_id = ?", nativeQuery = true)
    Customer selectCustomer(Long id);

    Customer findByName(String name);

    /**
     * 模糊查询 -Like
     * */
    List<Customer> findByNameLike(String name);

    Customer findByNameLikeAndAddress(String name, String address);
}
