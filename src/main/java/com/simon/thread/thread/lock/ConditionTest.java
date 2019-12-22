package com.simon.thread.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author simon
 * @Date 2019-10-23 22:02
 */
public class ConditionTest {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            lock.lock();
            System.out.println("await 时间为 :" + System.currentTimeMillis());
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();

        Thread.sleep(1000);
        lock.lock();
        System.out.println("signal 时间为 : " + System.currentTimeMillis());
        condition.signal();
        lock.unlock();

    }
}
