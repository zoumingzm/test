package com.zm.mybatis.service;

import com.zm.mybatis.dao.UserDao;
import com.zm.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zouming on 17-3-10.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public User insertUserWithBackId(User user){
        userDao.insertUserWithBackId(user);
        return user;
    }
}
