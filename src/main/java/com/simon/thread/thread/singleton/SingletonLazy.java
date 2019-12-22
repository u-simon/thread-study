package com.simon.thread.thread.singleton;

/**
 * @Author simon
 * @Date 2019-11-06 21:51
 */
public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    private SingletonLazy(){}

    public static SingletonLazy getInstance()  {
        if (singletonLazy == null){
            synchronized (SingletonLazy.class){
                if (singletonLazy == null){
                    singletonLazy = new SingletonLazy();
                }
            }

        }
        return singletonLazy;
    }


    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(SingletonLazy.getInstance().hashCode());
        }).start();

        new Thread(()->{
            System.out.println(SingletonLazy.getInstance().hashCode());
        }).start();

        new Thread(()->{
            System.out.println(SingletonLazy.getInstance().hashCode());
        }).start();
    }
}
