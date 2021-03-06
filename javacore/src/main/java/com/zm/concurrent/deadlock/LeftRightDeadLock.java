package com.zm.concurrent.deadlock;

/**
 * Created by Administrator on 2017/3/12.
 */
public class LeftRightDeadLock {

    private Object left = new Object();
    private Object right = new Object();

    public void leftRight(){
        synchronized (left){
            System.out.println(Thread.currentThread().getName());
            synchronized (right){
                System.out.println("leftRight...");
            }
        }
    }

    public void rightLeft(){
        synchronized (right){
            System.out.println(Thread.currentThread().getName());
            synchronized (left){
                System.out.println("rightLeft...");
            }
        }
    }

    public static void main(String[] args){
        LeftRightDeadLock leftRightDeadLock = new LeftRightDeadLock();
        Thread t1 = new Thread(() -> {
            leftRightDeadLock.leftRight();
        });

        Thread t2 = new Thread(() -> {
            leftRightDeadLock.rightLeft();
        });

        t1.start();
        t2.start();
    }
}
