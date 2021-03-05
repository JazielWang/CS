package Jaziel.mapper;

import Jaziel.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/29 16:38
 */
public interface RoleMapper {
    @Select("select * from sys_role sr, sys_user_role sur where sr.id=sur.roleid and sur.userid=#{uid}")
    List<Role> findById();
}
