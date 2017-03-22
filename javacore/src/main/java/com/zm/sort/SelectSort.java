package com.zm.sort;

/**
 * 选择排序
 * Created by zouming on 17-3-20.
 */
public class SelectSort implements BaseSort {

    public static void main(String[]args){
        SelectSort _this = new SelectSort();
        _this.sort(_this.initInteger());
    }

    @Override
    public void sort(Integer[]a){
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]){//每次找出未排序的最值
                    minIndex = j;
                }
            }
            if (i != minIndex){ //如果最值位置不是未排序的第一个位置，则交换其值，最多交换n次
                exchange(a, minIndex,i);
            }
            print(a);
        }

    }
}
