package com.zm.inherit;

/**
 * Created by Administrator on 2017/4/1.
 */
public class SubClass extends BaseClass {

    private  String subStr;

    public void setSubStr(String subStr){
        this.subStr = subStr + pub + pro + def;
    }
}
