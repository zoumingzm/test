package com.zm.mybatis.dao;

import com.zm.mybatis.entity.User;
import com.zm.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by zouming on 17-3-10.
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public Integer insertUserWithBackId(User user){
        return userMapper.insertUserWithBackId(user);
    }

    public User getById(Integer id){
        return userMapper.getById(id);
    }
}
