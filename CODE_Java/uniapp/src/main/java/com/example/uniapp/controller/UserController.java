package com.example.uniapp.controller;

import com.example.uniapp.pojo.Students;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @RequestMapping("/show")
    public List<Students> show(){
        Students student1 = new Students();
        student1.setName("张三");
        student1.setAge(20);
        student1.setGender("男");
        student1.setPassword("123123");

        Students student2 = new Students();
        student2.setName("李四");
        student2.setAge(21);
        student2.setGender("女");
        student2.setPassword("232323");

        List<Students> list =  new ArrayList<>();
        list.add(student1);
        list.add(student2);
        return list;

    }
}
