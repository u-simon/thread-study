package com.simon.thread.thread.exception;

/**
 * @Author simon
 * @Date 2019-08-16 21:45
 */
public class Service {

    public synchronized void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("Thread = " + Thread.currentThread().getName() + " run beginTime = " + System.currentTimeMillis());

            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThradName = " + Thread.currentThread().getName() + " run exceptionTime=" + System.currentTimeMillis());

                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run time + " + System.currentTimeMillis());
        }
    }

}
