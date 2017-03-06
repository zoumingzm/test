package com.zm.sysout;

import java.io.PrintStream;

/**
 * Created by Administrator on 2017/3/6.
 */
public class SysoutOverrite {

    public static void main(String[]args){
        int a = 10;
        int b = 10;
        method(a,b);
        System.out.println("a="+a);//a=100
        System.out.println("b="+b);//b=100
    }

    public static void method(int a, int b){
        PrintStream ps = new PrintStream(System.out){
            @Override
            public void println(String x) {
                if ("a=10".equals(x)){
                    x = "a=100";
                }else {
                    x = "b=100";
                }
                super.println(x);
            }
        };
        System.setOut(ps);
    }
}
