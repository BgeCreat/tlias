package com.itbge.controller;

import com.itbge.utils.JwtUtils;
import com.itbge.pojo.Result;
import com.itbge.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if ("jinyong".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
            String token = JwtUtils.generateToken(user.getUsername());
            System.out.println(token);
            return Result.success(token);
        } else {
            return Result.error("登录失败");
        }
    }
}
