package com.Jaziel.POJO;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * @author 王杰
 * @date 2021/5/3 13:45
 */
@Entity
@Table(name = "cst_linkman")
@Data

public class LinkMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long id;
    @Column(name = "lkm_name")
    private String name;
    @Column(name = "lkm_gender")
    private String gender;
    @Column(name = "lkm_phone")
    private String phone;
    @Column(name = "lkm_mobile")
    private String mobile;
    @Column(name = "lkm_email")
    private String email;
    @Column(name = "lkm_position")
    private String position;
    @Column(name = "lkm_memo")
    private String memo;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private Customer customer;
}
