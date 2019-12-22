package com.simon.thread.thread.twoobjecttuolock;

/**
 * @Author simon
 * @Date 2019-08-13 21:34
 */
public class ThreadA extends Thread {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadA(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("a");
    }
}
