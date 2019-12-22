package com.simon.thread.thread.singleton;

/**
 * @Author simon
 * @Date 2019-11-06 22:12
 */
public class SingletonStatic {

    private SingletonStatic() {
    }

    private static SingletonStatic singletonStatic;

    static {
        System.out.println("1123");
        singletonStatic = new SingletonStatic();
    }

    public static SingletonStatic getInstance(){
        return SingletonStatic.singletonStatic;
    }

    public static void main(String[] args) {
        new SingletonStatic();
    }
}
