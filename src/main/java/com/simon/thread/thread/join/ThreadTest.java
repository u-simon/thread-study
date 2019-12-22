package com.simon.thread.thread.join;

/**
 * @Author simon
 * @Date 2019-10-21 22:06
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                int secondValue = (int) (Math.random() * 10000);
                System.out.println(secondValue);
                Thread.sleep(secondValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
//        Thread.sleep();
        System.out.println("我想当thread对象执行完毕后我在执行");
        System.out.println("但上面代码中的sleep()中的值应该写多少呢");
        System.out.println("答案是不确定");
    }
}
