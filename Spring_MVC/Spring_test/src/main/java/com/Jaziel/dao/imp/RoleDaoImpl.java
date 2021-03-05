package com.Jaziel.dao.imp;

import com.Jaziel.dao.RoleDao;
import com.Jaziel.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/17 14:06
 */
public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        List<Role> query = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return query;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role value(?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> getNameById(long id) {
        List<Role> roleList = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where ur.roleID=r.id and ur.userID=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roleList;
    }
}
