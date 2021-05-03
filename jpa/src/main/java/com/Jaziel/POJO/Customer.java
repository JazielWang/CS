package com.Jaziel.POJO;

import lombok.Data;
import javax.persistence.*;

import java.io.Serializable;

/**
 * @author 王杰
 * @date 2021/4/27 20:17
 */
@Data
@Entity
@Table(name = "cst_customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long id;
    @Column(name = "cust_name")
    private String name;
    @Column(name = "cust_source")
    private String source;
    @Column(name = "cust_industry")
    private String industry;
    @Column(name = "cust_level")
    private int level;
    @Column(name = "cust_address")
    private String address;
    @Column(name = "cust_phone")
    private String phone;
}
