package com.simon.thread.thread;

/**
 * @Author simon
 * @Date 2019-06-21 21:07
 */
public class MyThread extends Thread {

    private int count = 5;

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        count--;
        System.out.println("由" + Thread.currentThread().getName() + " 计算 count = " + count) ;
    }
}