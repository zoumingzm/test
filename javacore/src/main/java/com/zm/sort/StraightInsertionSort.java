package com.zm.sort;

/**
 * 直接插入排序
 * Created by Administrator on 2017/3/17.
 */
public class StraightInsertionSort extends BaseSort{

    public static void main(String[] args){
        Integer[] ary = initInteger();
        sortAsc(ary);

    }

    public static void sortAsc(Integer[] a){
        for(int i= 1; i<a.length; i++){
            int temp = a[i];  //哨兵
            int j = i - 1;

            while (j>=0 && temp < a[j]){
                a[j+1] = a[j];
                j -- ;
            }
            a[j+1] = temp;
            print(a);
        }
    }
}

