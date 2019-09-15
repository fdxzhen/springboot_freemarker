package com.zhenhao.controller;

import com.zhenhao.bean.User;
import com.zhenhao.service.UserService;
import com.zhenhao.util.ReturnsDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/register")
    public String register(){
        return "/system/register";
    }
    @RequestMapping(value = "/login")
    public String hello(){
        return "/system/login";
    }

    @RequestMapping("/index")
    public String index(User user, Model model){
        System.out.println(user);
        if(user.getName()==null || user.getPwd()==null||user.getSecondPwd()==null|| user.getPwd() !=user.getSecondPwd()){
            model.addAttribute("info","必填选项不能为空，或用户名和密码不一致");
            return "/system/register";
        }
        userService.userRegister(user);
        model.addAttribute("user",user);
        return "/system/index";
    }

    @RequestMapping("/main")
    public String main(User user,Model model){
        System.out.println(user);
        String pwd = userService.getPwdByName(user);
        if(!pwd.equals(user.getPwd())){
            model.addAttribute("info","密码不正确");
            return "/system/login";
        }
        return "/system/index";
    }

    @RequestMapping("/test")
    public String test(Model model,User user){
        ReturnsDatas returnsDatas = new ReturnsDatas();
        returnsDatas.setQueryBean(user);
        model.addAttribute("returnDatas",returnsDatas);
        return "/system/test";
    }
}
