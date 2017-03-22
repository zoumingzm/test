package com.zm.sort;

/**
 * Created by Administrator on 2017/3/21.
 */
public class QuickSort implements BaseSort{

    public static void main(String[] args){
        QuickSort _this = new QuickSort();
        Integer[] a = _this.initInteger();
//        Integer[] a = {1,1,1,6,6,6,6,3,3,3,2,2,2,4,4,7,7,8,8,5,5};
        _this.sort(a);
    }

    @Override
    public void sort(Integer[] ary) {
        sort(ary, 0 , ary.length-1);
    }

    private void sort(Integer[] ary, int startIndex, int endIndex){
        if (startIndex < endIndex) {
            //选一个基准，并返回基准位置的index
            int midIndex = partition(ary, startIndex, endIndex);
            //左递归
            sort(ary, startIndex, midIndex-1);
            //又递归
            sort(ary, midIndex+1, endIndex);
            print(ary);
        }
    }

    int partition(Integer[] ary, int startIndex, int endIndex){
        int base = ary[endIndex];
        int tailIndex = startIndex - 1;
        for (int i = startIndex; i < endIndex; i++) {
            if (ary[i] <= base){
                tailIndex ++ ;
                if (tailIndex != i && ary[tailIndex] != ary[i]){
                    exchange(ary, tailIndex, i);
                }
            }
        }
        exchange(ary, tailIndex+1, endIndex);
        return tailIndex+1;
    }
}
