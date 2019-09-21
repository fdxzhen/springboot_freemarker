package com.zhenhao.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhenhao.bean.User;
import com.zhenhao.service.UserService;
import com.zhenhao.util.ReturnsDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController extends BaseController{

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
        model.addAttribute("user",user);
        return "/system/index";
    }

    @RequestMapping("/test")
    public String test(Model model,User user){
        ReturnsDatas returnsDatas = new ReturnsDatas();
        returnsDatas.setQueryBean(user);
        model.addAttribute("returnDatas",returnsDatas);
        return "/system/test";
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request,Model model,User user){
        ReturnsDatas returnsDatas = new ReturnsDatas();
        Page page = newPage(request);
        PageInfo<User> userPageInfo = userService.getUserByPage(page,user);
        returnsDatas.setData(userPageInfo);
        returnsDatas.setQueryBean(user);
        model.addAttribute("returnsDatas",returnsDatas);
        return "/system/list";
    }


    @RequestMapping("/user/editUser")
    public String editUser(Model model,@RequestParam("name") String  name)
    {
        User user = null;
        if(name!=null){
            user=userService.getUserByName(name);
        }
        model.addAttribute("user",user);
        return "/system/user/editUser";
    }

    @ResponseBody
    @RequestMapping("/user/uploadImg/")
    public Map<String,Object> uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request){
//        String filepath = request.getServletContext().getRealPath("/photo"); //原文的

//        ResourceUtils.getURL("classpath:").getPath()
        String filepath =System.getProperty("user.dir")+"//freemarker//src//main//resources//static";
        User user = userService.getUserByName(request.getParameter("name"));

//        String filepath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
//        System.out.println(filepath);
//        String filename = System.currentTimeMillis()+file.getOriginalFilename();
//        System.out.println("***"+file.getResource().getFilename());
        String filename = file.getOriginalFilename();
        File file2 = new File(filepath);

        if (!file2.exists()) {
            file2.mkdirs();
        }
        String savepath = filepath+"\\"+filename;
        user.setImgUrl(savepath);
        userService.updateUser(user);
        System.out.println("轮播图保存路径:"+savepath);
        Map map = new HashMap<String,Object>();
        try {
            //保存文件到服务器
            file.transferTo(new File(savepath));
            //保存到数据库

            //返回json
            map.put("msg","ok");
            map.put("code",200);
            /*加不加这个都行
            map.put("data",new HashMap<String,Object>(){
                {
                    put("src",savepath);
                }
            });*/

        } catch (Exception e) {
            map.put("msg","error");
            map.put("code",0);
            e.printStackTrace();
        }

        return map;
    }


}
