package com.simon.thread.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author simon
 * @Date 2019-10-23 21:59
 */
public class LockTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    public static void main(String[] args) {
        new Thread(()->{
            lock.lock();
            System.out.println("A");
            try {
                condition.await();
                System.out.println("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
