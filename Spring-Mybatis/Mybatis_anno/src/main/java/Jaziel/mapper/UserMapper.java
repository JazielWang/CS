package Jaziel.mapper;

import Jaziel.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/25 16:53
 */
public interface UserMapper {

    /** 多对多 */
    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "Jaziel.mapper.RoleMapper.findById")
            )
    })
    List<User> findUserAndRole();

    /** 一对多 */
    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class, // 此处需要封装的类型是 List，虽然内部是 order 对象的引用
                    many = @Many(select = "Jaziel.mapper.OrderMapper.findById")
            )
    })
    List<User> findUserAndOrderAll();

    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void update(User user);

    @Delete("delete from user where id=#{id}")
    public void delete(int id);

    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select * from user")
    List<User> findAll();
}
