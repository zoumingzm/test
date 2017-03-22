package com.zm.sort;

/**
 * 冒泡排序
 * Created by Administrator on 2017/3/19.
 */
public class BubbleSort implements BaseSort{

    public static void main(String[] args){
        BubbleSort _this = new BubbleSort();
        Integer[] ary = _this.initInteger();
        _this.sort(ary);

    }

    @Override
    public void sort(Integer[] ary){
        for (int i = 0; i<ary.length; i++){
            //每循环一次找出一个最值，每循环一次最多会交换n*(n-1)次
            for (int j = i+1; j<ary.length; j++){
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
