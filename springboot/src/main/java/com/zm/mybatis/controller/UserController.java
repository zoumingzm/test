package com.zm.mybatis.controller;

import com.zm.mybatis.entity.User;
import com.zm.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zouming on 17-3-10.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User insertUserWithBackId(@RequestBody User user){
//        User user = new User();
//        user.setName(userName);
//        user.setAge(age);
        return userService.insertUserWithBackId(user);
    }

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public User insertUserWithBackId(String name, Integer age){
                User user = new User();
                user.setName(name);
                user.setAge(age);
        return userService.insertUserWithBackId(user);
    }
}
