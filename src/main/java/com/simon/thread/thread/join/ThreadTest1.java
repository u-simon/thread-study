package com.simon.thread.thread.join;

/**
 * @Author simon
 * @Date 2019-10-21 22:09
 */
public class ThreadTest1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                int secondValue = (int) (Math.random() * 10000);
                System.out.println(secondValue);
                Thread.sleep(secondValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();

        System.out.println("我想当thread对象执行完毕后再执行，我做到了");
    }
}
