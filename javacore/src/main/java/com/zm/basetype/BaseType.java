package com.zm.basetype;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/23.
 */
public class BaseType {

    public static strictfp void main(String[] args){
        int i = 100_100_100;
        int j = 100100100;

        System.out.println(i == j);

        System.out.println(Double.isNaN(i));
//        \u00A0
        System.out.println(Long.reverse(3458764513820540928l));

        System.out.println(15/2);
        System.out.println(15/2.0);
        System.out.println(15d/0d);

        int x = 3;
        x += 3.5;
//        x = x+3.5;



    }

    @Test
    public void test(){
        int j = 1;
        int k = 1;
        for (int i = 0; i < 100_000_000 ; i++) {
            j = j ++;
            k = ++ k;
        }

        System.out.println(j);
        System.out.println(k);
    }

    @Test
    public void test1(){
        int j = 01111;
        int k = 01111;
        j = j<<2;
        k=k>>>2;
        System.out.println(j);
        System.out.println(k);
        System.out.println("\u2122");
    }

    @Test
    public void testString(){

        System.out.println(String.join("-", Arrays.asList("!","!","@")));
    }
}
