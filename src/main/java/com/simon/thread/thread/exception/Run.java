package com.simon.thread.thread.exception;

/**
 * @Author simon
 * @Date 2019-08-16 21:48
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        new Thread(()->{
            service.testMethod();
        }, "a").start();
        Thread.sleep(500);

        new Thread(()->{
            service.testMethod();
        }, "b").start();
    }
}
