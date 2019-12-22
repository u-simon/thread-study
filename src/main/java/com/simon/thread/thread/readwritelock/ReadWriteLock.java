package com.simon.thread.thread.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author simon
 * @Date 2019-10-30 22:01
 */
public class ReadWriteLock {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        new Thread(()->{
            try {
                lock.readLock().lock();
                System.out.println("获取读锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

                Thread.sleep(10000);
            } catch (Exception e){

            } finally {
                lock.readLock().unlock();
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
