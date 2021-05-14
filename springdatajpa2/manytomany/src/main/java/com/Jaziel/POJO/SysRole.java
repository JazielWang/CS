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

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }

    /**
     * 放弃外键维护权
     *
     * @ManyToMany(targetEntity = SysUser.class)
     * @JoinTable(name = "sys_user_role",
     * //当前对象：中间表中当前表对应的外键，以及它对应主键
     * joinColumns = {@JoinColumn(name = "roleid", referencedColumnName = "id")},
     * //对方对象：中间表中当前表对应的外键，以及它对应主键
     * inverseJoinColumns = {@JoinColumn(name = "userid", referencedColumnName = "id")})
     */
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
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
