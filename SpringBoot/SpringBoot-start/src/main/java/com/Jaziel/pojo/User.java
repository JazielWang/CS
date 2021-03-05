package com.Jaziel.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 王杰
 * @time 2020/11/4 14:40
 * 在编译阶段会自动更加注释生成对应的方法，包含：set/get/toString/hashCode/equals方法
 */
@Data
@Table(name = "tb_user")
public class User {
    @Id
    // 开启主键自动回填
    @KeySql(useGeneratedKeys = true)
    private Long id;
    //user_name --> userName
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String note;
    private Date created;
    private Date updated;
}
