package com.simon.thread.thread.producerconsumer.onepnc;

/**
 * @Author simon
 * @Date 2019-09-25 22:14
 */
public class C {
    private MyStack myStack;

    public C(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop = " + myStack.pop());
    }
}
