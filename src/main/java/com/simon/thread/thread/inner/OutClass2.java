package com.simon.thread.thread.inner;

/**
 * @Author simon
 * @Date 2019-10-16 21:13
 */
public class OutClass2 {

    static class InnerClass1 {

        public void method1(InnerClass2 innerClass2) {
            synchronized (innerClass2) {
                System.out.println("进入InnerClass1类中的method1方法");
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("离开InnerClass1类中的method1方法");
            }
        }

        public synchronized void method2() {
            System.out.println("进入InnerClass1类中的method2方法");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("离开InnerClass1类中的method2方法");
        }
    }

    static class InnerClass2 {
        public synchronized void method1() {
            System.out.println("进入InnerClass2类中的method1方法");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("离开InnerClass2类中的method1方法");
        }
    }
}
