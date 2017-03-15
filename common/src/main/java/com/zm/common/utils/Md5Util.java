package com.zm.common.utils;

import java.security.MessageDigest;

/**
 * Created by zouming on 17-3-10.
 */
public class Md5Util {

    public static String encodeMd5(String oriString){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = oriString.getBytes();
            md.update(passwordBytes);
            byte[] result = md.digest();
            int i;
            StringBuffer finalString = new StringBuffer();
            for (int j = 0; j < result.length; j++) {
                i = result[j];
                if (i<0){
                    i += 256;
                }
                if (i<16){
                    finalString.append("0");
                }else {
                    finalString.append(Integer.toHexString(i));
                }
            }
            return finalString.toString();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("密码加密失败。",e);
        }
    }
}
