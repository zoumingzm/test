package com.zm.reflect;

import java.io.IOException;
import java.sql.SQLDataException;

/**
 * Created by zouming on 17-4-5.
 */
public class UserInfo<T, V> {
    private String name;

    private Integer age;

    private SexEnum sex;

    private String address;

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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private T test(V str1, String str2) throws IOException,SQLDataException{
        return null;
    }
}
