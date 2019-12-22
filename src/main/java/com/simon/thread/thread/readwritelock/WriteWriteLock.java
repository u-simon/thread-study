package com.simon.thread.thread.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author simon
 * @Date 2019-10-30 21:54
 */
public class WriteWriteLock {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        new Thread(()->{
            try {
                lock.writeLock().lock();
                System.out.println("获取写锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

                Thread.sleep(10000);
            } catch (Exception e){

            } finally {
                lock.writeLock().unlock();
            }
        }, "A").start();

        new Thread(()->{
            try {
                lock.writeLock().lock();
                System.out.println("获取写锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

                Thread.sleep(10000);
            } catch (Exception e){

            } finally {
                lock.writeLock().unlock();
            }
        }, "B").start();
    }
}
