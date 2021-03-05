package Jaziel.mapper;

import Jaziel.domain.Order;
import Jaziel.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/29 14:15
 */
public interface OrderMapper {

    @Select("select * from orders where id=#{id}")
    List<Order> findById();

    /*一对一数据表查询的两种方法*/

    @Select("select *, o.id oid from user u, orders o where u.id=o.uid")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(property = "user",//封装的属性名称
                    column = "uid",//根据哪个字段去查询 user 的数据
                    javaType = User.class, // 要封装的实体类型
                    // select 属性，代表需要使用哪个方法去获得数据
                    one = @One(select = "Jaziel.mapper.UserMapper.findById")
            )
    })
    List<Order> finaAll();

    /*@Select("select *, o.id oid from user u, orders o where u.id=o.uid")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "user.id"),
            @Result(column = "username", property = "user.username"),
            @Result(column = "password", property = "user.password")
    })
    public List<Order> finaAll();*/
}
