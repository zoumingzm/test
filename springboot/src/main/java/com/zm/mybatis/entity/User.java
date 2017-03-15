package com.zm.mybatis.entity;

import com.zm.common.utils.Md5Util;
import com.zm.common.utils.StringUtil;
import com.zm.exception.PasswordInvalidException;
import java.util.Date;

/**
 * Created by zouming on 17-3-10.
 */
public class User {

    private String id;

    private String userName;

    private String password;

    private String name;

    private Integer age;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (StringUtil.isEmpty(password)){
            throw new PasswordInvalidException("password is empty.");
        }
        this.password = Md5Util.encodeMd5(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
