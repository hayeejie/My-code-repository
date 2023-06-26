package com.example.backobject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backobject.domain.User;
import com.example.backobject.service.UserService;
import com.example.backobject.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author hayee
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-20 11:39:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




