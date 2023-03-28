package com.example.bootmpdemo.service;

import com.example.bootmpdemo.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface UserService extends IService<User> {
    String addUser(User user);
    Boolean loginUser(User user);
}
