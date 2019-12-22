package com.simon.thread.thread.singleton;

/**
 * @Author simon
 * @Date 2019-11-06 22:04
 */
public class SingletonInner {
    private SingletonInner() {

    }

    private static class SingletonInnerHandler {
        private static SingletonInner singletonInner = new SingletonInner();
    }

    public static SingletonInner getInstance() {
        return SingletonInnerHandler.singletonInner;
    }
}
