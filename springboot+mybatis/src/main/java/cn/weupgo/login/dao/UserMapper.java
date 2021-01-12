package cn.weupgo.login.dao;

import cn.weupgo.login.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserInfo(@Param("uid") String uid, @Param("uname")  String uname);
}
