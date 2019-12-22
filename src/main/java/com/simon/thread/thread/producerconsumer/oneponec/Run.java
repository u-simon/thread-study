package com.simon.thread.thread.producerconsumer.oneponec;

/**
 * @Author simon
 * @Date 2019-09-25 22:04
 */
public class Run {

    public static void main(String[] args) {
        String lock = new String("");
        new Thread(() -> {
            while (true)
                new P(lock).setValue();
        }).start();


        new Thread(() -> {
            while (true)
                new C(lock).getValue();
        }).start();
    }
}
