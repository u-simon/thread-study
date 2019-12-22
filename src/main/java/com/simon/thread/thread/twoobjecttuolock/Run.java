package com.simon.thread.thread.twoobjecttuolock;

/**
 * @Author simon
 * @Date 2019-08-13 21:38
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum1 = new HasSelfPrivateNum();

        new ThreadA(hasSelfPrivateNum).start();
        new ThreadB(hasSelfPrivateNum1).start();
    }
}
