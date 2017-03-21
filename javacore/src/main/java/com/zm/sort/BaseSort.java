package com.zm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2017/3/19.
 */
public interface BaseSort {

    default Integer[] initInteger(){
        Integer[] ary = new Integer[10];
        for(int i = 0; i < ary.length; i++) {
            ary[i] = new Random().nextInt(100);
        }
        return ary;
    }

    default void print(Integer[] ary){
        System.out.println("sorted ary is " + Arrays.toString(ary));

    }

    void sort(Integer[] ary);
}
