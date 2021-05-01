package com.Jaziel.dao;

import com.Jaziel.POJO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * @author 王杰
 * @date 2021/5/1 15:34
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer>{
}
