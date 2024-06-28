package com.itbge.controller;

import com.itbge.pojo.Result;
import com.itbge.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLogin {
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if(user.getUsername().equals("jinyong") && user.getPassword().equals("123456"))
            return Result.success();
        else
            return Result.error("登录失败");
    }
}
