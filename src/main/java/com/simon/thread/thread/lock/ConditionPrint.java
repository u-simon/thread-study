package com.simon.thread.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author simon
 * @Date 2019-10-25 22:01
 */
public class ConditionPrint {

    private static volatile boolean hasValue = true;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition printA = lock.newCondition();
        Condition printB = lock.newCondition();

        for (int i = 0; i < 10; i++){
            new Thread(() -> {
                try {
                    lock.lock();
                    while (hasValue) {
                        printA.await();
                    }
                    System.out.println("打印☆");
                    hasValue = true;
                    printB.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++){
            new Thread(() -> {
                try {
                    lock.lock();
                    while (!hasValue) {
                        printB.await();
                    }
                    System.out.println("打印★");
                    hasValue = false;
                    printA.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }
}
