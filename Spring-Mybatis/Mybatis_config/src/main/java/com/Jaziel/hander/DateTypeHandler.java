package com.Jaziel.hander;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author 王杰
 * @time 2020/10/27 14:59
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {

    @Override
    /** 将 java 类型 转换成 数据库所需要的类型 */
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i, time);
    }

    /**
     * String 参数：要转换字典名称
     * Resultset : 查询出的结果集
     * 将 数据库所需要的类型 转换成 java 类型 */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        // 获得结果集中所需要的数据（long）转换成 date 类型，并返回
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
}
