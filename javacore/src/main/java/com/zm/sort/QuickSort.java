package com.zm.sort;

/**
 * Created by Administrator on 2017/3/21.
 */
public class QuickSort implements BaseSort{

    public static void main(String[] args){
        QuickSort _this = new QuickSort();
        Integer[] a = _this.initInteger();
        _this.sort(a);
    }

    @Override
    public void sort(Integer[] ary) {
        sort(ary, 0 , ary.length-1);
    }

    private void sort(Integer[] ary, int startIndex, int endIndex){
        if (startIndex < endIndex) {
            int midIndex = partition(ary, startIndex, endIndex);
            sort(ary, startIndex, midIndex-1);
            sort(ary, midIndex+1, endIndex);
            print(ary);
        }
    }

    private void exchange(Integer[] ary, int indexA, int indexB){
        int temp = ary[indexA];
        ary[indexA] = ary[indexB];
        ary[indexB] = temp;
    }

    int partition(Integer[] ary, int startIndex, int endIndex){
        int base = ary[endIndex];
        int tailIndex = startIndex - 1;
        for (int i = startIndex; i < endIndex; i++) {
            if (ary[i] <= base){
                tailIndex ++ ;
                exchange(ary, tailIndex, i);
            }
        }
        exchange(ary, tailIndex+1, endIndex);
        return tailIndex+1;
    }
}
