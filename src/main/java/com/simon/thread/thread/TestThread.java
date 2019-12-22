package com.simon.thread.thread;

/**
 * @Author simon
 * @Date 2019-06-21 21:10
 */
public class TestThread {

    public static void main(String[] args) {
//        MyThread a = new MyThread();
//
//        new Thread(a, "A").start();
//        new Thread(a,"B").start();
//        new Thread(a, "C").start();
//        new Thread(a, "D").start();
//        new Thread(a, "E").start();

//        System.out.println(Thread.currentThread().getName());

        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }
}
