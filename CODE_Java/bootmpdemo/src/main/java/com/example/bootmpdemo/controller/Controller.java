package com.example.bootmpdemo.controller;

import com.example.bootmpdemo.domain.User;
import com.example.bootmpdemo.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {

    //主动注入
    final
    UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    /**
     * 接受 前台用户传递到后台的数据 即用户名 和 密码
     */
    @RequestMapping("/addUser")
    public  String addUser(@RequestParam("name") String name,@RequestParam("password") String password){
        //判空操作
        if (name.equals("")||password.equals("")){
            System.out.println("用户名或密码不能为空");
            return "用户名或密码不能为空";
        }
        //1.创建用户对象，并且使用有参构造方法接收数据
        User user = new User(name, password);
        //2.调用业务层接口实现类中的addUser(User User)方法

        //3.返回json数据到前端
        // （前端要根据后端接口返回的json数据进行下一步的操作，要么注册成功跳转，要么注册失败用户已存在）
        //返回的是success 或者用户已存在

        return userService.addUser(user);
    }
    @RequestMapping("/loginUser")
    public  Boolean loginUser(@RequestParam("name") String name,@RequestParam("password") String password){
        if (name.equals("")||password.equals("")){
            System.out.println("用户名或密码不能为空");
            return false;
        }
        User user = new User(name, password);
        return userService.loginUser(user);
    }

}
