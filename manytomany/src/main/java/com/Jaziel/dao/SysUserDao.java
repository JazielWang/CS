package com.Jaziel.dao;

import com.Jaziel.POJO.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-03 20:10:14
 */
public interface SysUserDao extends JpaRepository<SysUser, Long>, JpaSpecificationExecutor<SysUser> {

}

