package com.simon.thread.thread.reentrylock;

/**
 * @Author simon
 * @Date 2019-08-16 21:38
 */
public class SubClass extends Father {

    public synchronized void operateISubMEthod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i = " + i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (Exception e) {

        }
    }
}
