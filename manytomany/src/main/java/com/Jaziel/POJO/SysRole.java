package com.Jaziel.POJO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2021-05-03 20:12:31
 */
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "rolename")
    private String roleName;
    @Column(name = "roleDesc")
    private String roleDesc;

    @ManyToMany(targetEntity = SysUser.class)
    @JoinTable(name = "sys_user_role",
            //中间表user_role_rel字段关联sys_role表的主键字段role_id
            joinColumns = {@JoinColumn(name = "roleid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "userid", referencedColumnName = "ID")})
    private Set<SysUser> users = new HashSet<>();

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
