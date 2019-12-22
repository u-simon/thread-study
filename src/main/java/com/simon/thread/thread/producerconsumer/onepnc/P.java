package com.simon.thread.thread.producerconsumer.onepnc;

/**
 * @Author simon
 * @Date 2019-09-25 22:14
 */
public class P {
    private MyStack myStack;

    public P(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService(){
        myStack.push();
    }
}
