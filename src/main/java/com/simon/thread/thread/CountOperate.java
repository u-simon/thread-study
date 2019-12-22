package com.simon.thread.thread;

/**
 * @Author simon
 * @Date 2019-06-21 21:48
 */
public class CountOperate extends Thread {
    public CountOperate() {
        System.out.println("countOperator----begin");
        System.out.println("thread-name" + Thread.currentThread().getName());
        System.out.println("this.name" + this.getName());
        System.out.println("countOperator --- end");

    }

    @Override
    public void run() {
        System.out.println("run----begin");
        System.out.println("thread-name" + Thread.currentThread().getName());
        System.out.println("this.name" + this.getName());
        System.out.println("run --- end");
    }
}
