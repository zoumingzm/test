package com.zm.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;
import static java.lang.System.out;

/**
 * Created by zouming on 17-4-17.
 */
public class CountTask extends RecursiveTask<Integer> {

    private Integer start;

    private Integer end;

    private static final Integer THRESHOLD = 10_000_000;//阈值
    public CountTask(Integer start, Integer end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        Integer sum = 0;

        //是否在阈值范围内
        boolean isCompute = end - start <= THRESHOLD;
        if (isCompute){
            for (int i = start; i <= end; i ++){
                sum += i;
            }
        }else {
            int mid = (end + start)/2;
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid + 1, end);

//            out.println("excute thread is " + Thread.currentThread().getName());
            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待子人物执行完成，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public int cal(){
        int sum = 0;
        for (int i = start; i <= end; i ++){
            sum += i;
        }
        return sum;
    }
}
