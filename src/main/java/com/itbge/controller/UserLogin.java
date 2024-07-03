//package com.itbge.controller;
//
//import com.itbge.mapper.UserMapper;
//import com.itbge.pojo.Result;
//import com.itbge.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserLogin {
//
//    @Autowired
//    UserMapper userMapper;
//
//    @PostMapping("/login")
//    public Result login(@RequestBody User user) {
//        User loginmapper = userMapper.login(user.getUsername(), user.getPassword());
//        if (loginmapper != null) {
//            // 成功登录
//            return Result.success();
//        } else {
//            // 登录失败
//            return Result.error("用户或密码错误");
//        }
//    }
//}
//
