package com.simon.thread.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author simon
 * @Date 2019-10-25 21:56
 */
public class ConditionTest2 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();

        new Thread(()-> {
            try {
                lock.lock();
                System.out.println("begin awaitA time is : " + System.currentTimeMillis());
                conditionA.await();
                System.out.println("end awaitA time is : " + System.currentTimeMillis());
            } catch (Exception e){

            }finally {
                lock.unlock();
            }
        }).start();

        new Thread(()-> {
            try {
                lock.lock();
                System.out.println("begin awaitB time is : " + System.currentTimeMillis());
                conditionB.await();
                System.out.println("end awaitB time is : " + System.currentTimeMillis());
            } catch (Exception e){

            }finally {
                lock.unlock();
            }
        }).start();

        Thread.sleep(3000);

        lock.lock();
        conditionA.signalAll();
        lock.unlock();
    }
}
