package com.itbge.mapper;

import com.itbge.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User login(String username, String password);
}
