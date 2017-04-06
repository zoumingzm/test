package com.zm.mybatis.mapper;

import com.zm.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zouming on 17-3-10.
 */
public interface UserMapper {

    Integer insertUserWithBackId(User user);

    User getById(@Param("id") Integer id);
}
