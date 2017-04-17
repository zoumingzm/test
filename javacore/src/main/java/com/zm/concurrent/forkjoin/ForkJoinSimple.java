package com.zm.concurrent.forkjoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * Created by zouming on 17-4-17.
 */
public class ForkJoinSimple {

    @Test
    public void test(){
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        CountTask countTask = new CountTask(1,1_999_000_000);

        Future<Integer>future = forkJoinPool.submit(countTask);

        try{
            long t1 = System.currentTimeMillis();
            future.get();
//            out.println(future.get(10, TimeUnit.SECONDS));
            long t2 = System.currentTimeMillis();
            out.println(t2-t1);
            long t3 = System.currentTimeMillis();
            countTask.cal();
            long t4 = System.currentTimeMillis();
            out.println(t4-t3);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
