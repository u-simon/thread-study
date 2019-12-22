package com.simon.thread.thread.inner;

/**
 * @Author simon
 * @Date 2019-10-16 21:11
 */
public class Run {

    public static void main(String[] args) {
//        OuterClass.Inner inner = new OuterClass.Inner();
//
//        new Thread(()->{
//            inner.method1();
//        }, "A").start();
//
//        new Thread(()->{
//            inner.method2();
//        }, "B").start();


        OutClass2.InnerClass1 innerClass1 = new OutClass2.InnerClass1();
        OutClass2.InnerClass2 innerClass2 = new OutClass2.InnerClass2();
        new Thread(()->{
            innerClass1.method1(innerClass2);
        }, "A").start();
        new Thread(()->{
            innerClass2.method1();
        }, "B").start();

    }
}
