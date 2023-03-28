package com.example.bootmpdemo.mapper;

import com.example.bootmpdemo.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findUserByName(String name);

}




