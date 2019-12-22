package com.simon.thread.thread.reentrylock;

/**
 * @Author simon
 * @Date 2019-08-16 21:40
 */
public class Run {

    public static void main(String[] args) {

        new Thread(()->{
            new SubClass().operateISubMEthod();
        }).start();
    }
}
