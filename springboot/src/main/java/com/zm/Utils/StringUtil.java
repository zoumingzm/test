package com.zm.Utils;

/**
 * Created by zouming on 17-3-10.
 */
public class StringUtil {

    public static boolean isEmpty(String str){
        if (str == null || str.trim().length() == 0){
            return true;
        }else {
            return false;
        }
    }
}
