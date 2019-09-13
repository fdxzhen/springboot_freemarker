package com.zhenhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "login";
    }
    @ResponseBody
    @RequestMapping("/")
    public String h(){
        return "sndfkjsknksld";
    }

    @RequestMapping("/index")
    public String index(Model model){
        List<String> list = new LinkedList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        model.addAttribute("list",list);
        return "index";
    }
}
