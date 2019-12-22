package com.simon.thread.thread.inhert;

import java.util.Date;

/**
 * @Author simon
 * @Date 2019-10-23 21:46
 */
public class InhertThreadLoaclTest {

    static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal(){
        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }

        @Override
        protected Object childValue(Object parentValue) {
            return parentValue + " 我在子线程加的~";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            System.out.println("在Main线程中取值 = " + inheritableThreadLocal.get());
            Thread.sleep(100);
        }
        inheritableThreadLocal.set(new Date().getTime());

        new Thread(()-> {
            for (int i = 0; i < 10; i++){
                System.out.println("在子线程中取值 = " + inheritableThreadLocal.get());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
