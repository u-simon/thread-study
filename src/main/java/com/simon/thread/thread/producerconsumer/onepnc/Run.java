package com.simon.thread.thread.producerconsumer.onepnc;

/**
 * @Author simon
 * @Date 2019-09-25 22:15
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        new Thread(() -> {
            while (true)
                new P(myStack).pushService();
        }).start();
//        new Thread(() -> {
//            while (true)
//                new P(myStack).pushService();
//        }).start();
//        new Thread(() -> {
//            while (true)
//                new P(myStack).pushService();
//        }).start();
//        new Thread(() -> {
//            while (true)
//                new P(myStack).pushService();
//        }).start();



        new Thread(() -> {
            while (true)
                new C(myStack).popService();
        }).start();
        new Thread(() -> {
            while (true)
                new C(myStack).popService();
        }).start();
        new Thread(() -> {
            while (true)
                new C(myStack).popService();
        }).start();
        new Thread(() -> {
            while (true)
                new C(myStack).popService();
        }).start();


    }
}
