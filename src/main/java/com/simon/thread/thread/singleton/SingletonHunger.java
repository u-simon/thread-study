package com.simon.thread.thread.singleton;

/**
 * @Author simon
 * @Date 2019-11-06 21:47
 */
public class SingletonHunger {
    private static SingletonHunger singletonHunger = new SingletonHunger();

    private SingletonHunger() {
    }

    public static SingletonHunger getInstance() {
        return singletonHunger;
    }


    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(SingletonHunger.getInstance().hashCode());
        }).start();

        new Thread(()->{
            System.out.println(SingletonHunger.getInstance().hashCode());
        }).start();

        new Thread(()->{
            System.out.println(SingletonHunger.getInstance().hashCode());
        }).start();
    }
}
