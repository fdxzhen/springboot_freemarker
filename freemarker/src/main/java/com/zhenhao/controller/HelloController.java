package com.zhenhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
public class HelloController {





    @RequestMapping("admin")
    public String admin(){
        return "/admin/index";
    }
    @RequestMapping("admin/login")
    public String adminlogin(){
        return "/admin/login";
    }

    @RequestMapping("/page")
    public String page(){
        return "/system/page";
    }
    @RequestMapping("/flow")
    public String flow(){
        return "/system/flow";
    }
    @RequestMapping("/im")
    public String im(){
        return "/system/im";
    }
}
