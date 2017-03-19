package com.zm.sort;

/**
 * 冒泡排序
 * Created by Administrator on 2017/3/19.
 */
public class BubbleSort extends BaseSort{

    public static void main(String[] args){
        Integer[] ary = initInteger();
        sort(ary);

    }

    private static void sort(Integer[] ary){
        for (int i = 0; i<ary.length; i++){
            for (int j = 0; j<ary.length; j++){
                if (ary[i] < ary[j]){
                    int temp = ary[i];
                    ary[i] = ary[j];
                    ary[j] = temp;
                }
            }
            print(ary);
        }
    }
}
