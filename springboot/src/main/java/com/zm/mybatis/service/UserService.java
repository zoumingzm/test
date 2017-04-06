package com.zm.mybatis.service;

import com.zm.mybatis.dao.UserDao;
import com.zm.mybatis.entity.User;
import com.zm.mybatis.moredatasource.ReadOnlyConnection;
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
        Integer id = userDao.insertUserWithBackId(user);
        user.setId(id.toString());
        return user;
    }

    @ReadOnlyConnection
    public User getById(Integer id){
        return userDao.getById(id);
    }
}
