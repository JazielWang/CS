package com.Jaziel.dao.imp;

import com.Jaziel.dao.UserDao;
import com.Jaziel.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/17 19:52
 */
public class UserDaoImp implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> user = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public Long save(User user) {
        //创建 PreparedStatementCreator
        PreparedStatementCreator statementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 使用原始 jdbc 完成 PreparedStatementCreator 的组建
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user value (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setObject(2, user.getUsername());
                preparedStatement.setObject(3, user.getPassword());
                preparedStatement.setObject(4, user.getEmail());
                preparedStatement.setObject(5, user.getPhoneNum());
                return preparedStatement;
            }
        };

        // 创建 keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(statementCreator, keyHolder);
        // 获得生成的主键
        long id = keyHolder.getKey().longValue();
        //jdbcTemplate.update("insert into sys_user value (?,?,?,?,?)", null, user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNum());
        // 返回当前保存用户 id ，该 id 是数据库自动生成的
        return id;
    }

    @Override
    public void saveIDByRel(Long id, Long[] roleIds) {
        for (Long role : roleIds) {
            jdbcTemplate.update("insert into sys_user_role value (?,?)", id, role);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userID=?", userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where ID=?", userId);
    }

    @Override
    public User loginByUsernameAndePassword (String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?", new BeanPropertyRowMapper<>(User.class), username, password);
        return user;
    }
}
