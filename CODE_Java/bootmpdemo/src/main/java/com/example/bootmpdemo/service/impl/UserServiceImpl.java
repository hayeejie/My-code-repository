package com.example.bootmpdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bootmpdemo.domain.User;
import com.example.bootmpdemo.service.UserService;
import com.example.bootmpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * （1）用户名相同，密码不相同也可以正常注册
 * （2）用户名不同，密码相同或者不相同也可以正常注册
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public String addUser(User user) {

        //（1）用户名相同，密码不相同也可以正常注册

        //1.创建一个条件构造器，类型User，即你要查询的实体数据
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //2.获取前台用户输入的用户名
        queryWrapper.eq("name",user.getName());
        //3.根据用户名去数据库查询用户数据，可能有多条同名的数据
        List<User> users = userMapper.selectList(queryWrapper);
        //4.循环遍历结果集
        for (User userreg:users) {
            //每循环一次拿到一个对象，判断数据库中存储的密码和前台用户输入的密码匹配，不一致可以正常注册
            if (!userreg.getPassword().equals(user.getPassword())){
                userMapper.insert(user);
                System.out.println("注册成功");
                return "success";
            }
        }

        //（2）用户名不同，密码相同或者不相同也可以正常注册


        //1.根据用户名去数据库查询是否存在该用户
        User userByName = userMapper.findUserByName(user.getName());
        //2.判断用户是否存在，如果不存在，那就可以正常注册，如果存在，那就不可以正常注册，重新输入
        if (userByName==null){
            userMapper.insert(user);
            System.out.println("注册成功");
            return "success";
        }else {
            System.out.println("注册失败");
            return "用户已存在";
        }
    }
    public Boolean loginUser(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",user.getName()).eq("password",user.getPassword());
        List<User> users = userMapper.selectList(queryWrapper);
        for(User userreg:users) {
            if (userreg.getPassword().equals(user.getPassword())) {
                System.out.println("登录成功");
                return true;
            } else {
                System.out.println("登陆失败，请检查账号密码");
                return false;
            }
        }
        return null;
    }
}




