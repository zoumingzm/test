package com.zm.exception;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2017/4/3.
 */
public class AnalysException {

    @Test
    public void test() throws SQLException{
        try {
            throw new SQLException();
        } catch (Exception e){
            throw e;
        }
    }

    @Test
    public void test1(){
        try {
            throw new SQLException();
        } catch (Exception e){
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement element:stackTraceElements){
                System.out.println(element.toString());
            }
        }
    }

    @Test
    public void testThreadAllStackTrace(){
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Thread t:map.keySet()) {
            StackTraceElement[]e = map.get(t);
            for (StackTraceElement s : e){
                System.out.println(s.toString());
            }
        }

    }

    @Test
    public void testExceptionTime(){
        Stack s = new Stack();
        Long startTime = System.nanoTime();
        for (int i = 0; i < 1000000 ; i++) {
            if (!s.isEmpty()){
                s.pop();
            }
        }
        Long totalTime = System.nanoTime() - startTime;
        System.out.println("normal: " + totalTime/1000000);

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000 ; i++) {
            try{
                s.pop();
            } catch (Exception e){
//                e.toString();
            }
        }
        totalTime = System.nanoTime() - startTime;
        System.out.println("exception: " + totalTime/1000000);



    }
}
