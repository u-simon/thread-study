package com.simon.thread.thread.producerconsumer.onepnc;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author simon
 * @Date 2019-09-25 22:09
 */
public class MyStack {

    private List list= new ArrayList<>();

    public synchronized void push(){
        try {
            while (this.list.size() == 1){
                this.wait();
            }
            list.add(Math.random());
            this.notifyAll();
            System.out.println("push = " + list.size());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized String pop(){
        String returnValue = "";
        try {
            while (this.list.size() == 0){
                this.wait();
            }

            returnValue = list.get(0) + "";
            list.remove(0);
            this.notifyAll();
            System.out.println("pop = " + list.size());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return returnValue;
    }
}
