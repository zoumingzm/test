package com.zm.inherit.package2;

import com.zm.inherit.BaseClass;

/**
 * Created by Administrator on 2017/4/1.
 */
public class Package2 {
    private String package2;

    protected String proPac2;

    String defPac2;

    private BaseClass baseClass;

    public void setPackage2(String package2){
        this.package2 = package2 + baseClass.pub;
    }
}
