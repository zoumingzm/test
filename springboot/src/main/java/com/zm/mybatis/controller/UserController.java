package com.zm.mybatis.controller;

import com.zm.common.utils.Md5Util;
import com.zm.common.utils.StringUtil;
import com.zm.exception.PasswordInvalidException;
import com.zm.mybatis.entity.User;
import com.zm.mybatis.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
        setPassword(user);
        return userService.insertUserWithBackId(user);
    }

    @ApiOperation(value = "新增用户", notes = "根据姓名，年龄新增用户。", response = User.class, httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
        @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "Integer")})
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public User insertUserWithBackId(String name, Integer age){
                User user = new User();
                user.setName(name);
                user.setAge(age);
        setPassword(user);
        return userService.insertUserWithBackId(user);
    }

    @ApiOperation(value = "根据ID获取用户", notes = "根据ID获取用户", response = User.class, httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Integer")
    @RequestMapping(value = "/users/{id}")
    public User getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    private void setPassword(User user){
        if (StringUtil.isEmpty(user.getPassword())){
            throw new PasswordInvalidException("password is empty.");
        }
        user.setPassword(Md5Util.encodeMd5(user.getPassword()));
    }
}
