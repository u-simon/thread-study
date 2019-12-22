package com.simon.thread.thread.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author simon
 * @Date 2019-10-30 21:46
 */
public class ReadReadLock {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        new Thread(()->{
            try {
                reentrantReadWriteLock.readLock().lock();
                System.out.println("获取读锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

                Thread.sleep(10000);
            } catch (Exception e){

            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        }, "A").start();

        new Thread(()->{
            try {
                reentrantReadWriteLock.readLock().lock();
                System.out.println("获取读锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

                Thread.sleep(10000);
            } catch (Exception e){

            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        }, "B").start();
    }
}
