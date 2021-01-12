package cn.weupgo.login.service;

import cn.weupgo.login.dao.UserMapper;
import cn.weupgo.login.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(String uid,String uname){
          return userMapper.getUserInfo(uid,uname);
    }

}
