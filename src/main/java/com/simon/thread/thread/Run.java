package com.simon.thread.thread;

/**
 * @Author simon
 * @Date 2019-08-13 21:33
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();

        new ThreadA(hasSelfPrivateNum).start();
        new ThreadB(hasSelfPrivateNum).start();
    }
}
