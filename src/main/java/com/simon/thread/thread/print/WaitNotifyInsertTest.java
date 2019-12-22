package com.simon.thread.thread.print;

/**
 * @Author simon
 * @Date 2019-10-17 22:06
 */
public class WaitNotifyInsertTest {

    private volatile boolean prevIsA = false;

    public synchronized void backA() throws InterruptedException {
        if (prevIsA) {
            wait();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("★★★★★");
        }
        prevIsA = true;
        notifyAll();
    }

    public synchronized void backB() throws InterruptedException {
        if (!prevIsA) {
            wait();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("☆☆☆☆☆");
        }
        prevIsA = false;
        notifyAll();
    }


    public static void main(String[] args) {

        WaitNotifyInsertTest waitNotifyInsertTest = new WaitNotifyInsertTest();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    waitNotifyInsertTest.backA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();


            new Thread(()->{
                try {
                    waitNotifyInsertTest.backB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
