package com.simon.thread.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author simon
 * @Date 2019/12/22 14:29
 */
public class CasDemo {
    /**
     * CAS -> compareAndSet
     *  比较交换
     */
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + " ---- " + atomicInteger.get());

    }
}
