package cn.weupgo.login.controller;

import cn.weupgo.login.po.User;
import cn.weupgo.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @Autowired(required = false)
    UserService userService;
    @RequestMapping("/login1")
    public String show(){
        return "login";
    }
    @RequestMapping("/checkInfo")
    public String CheckInfo(  String uid,  String uname){
        System.out.println("123");
        User user=userService.login(uid,uname);
        if(user==null){
            return "fail";
        }else{
            return "success";
        }
    }
}
