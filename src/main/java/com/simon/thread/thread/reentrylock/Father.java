package com.simon.thread.thread.reentrylock;

/**
 * @Author simon
 * @Date 2019-08-16 21:36
 */
public class Father {
    public int i = 10;

    public synchronized  void operateIMainMethod(){
        try {
            i--;
            System.out.println("Father print i= " + i);
            Thread.sleep(100);
        } catch (Exception e){

        }
    }
}
