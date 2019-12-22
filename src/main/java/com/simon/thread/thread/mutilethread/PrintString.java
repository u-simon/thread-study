package com.simon.thread.thread.mutilethread;

/**
 * @Author simon
 * @Date 2019-08-26 21:53
 */
public class PrintString implements  Runnable{

    private  boolean continuePrint = true;

    public boolean isContinuePrint() {
        return continuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        this.continuePrint = continuePrint;
    }

    public void printStringMethod(){
        try {
            while (continuePrint){
                System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                 Thread.sleep(1000);
            }
        } catch (Exception e){

        }
    }

    @Override
    public void run() {
        printStringMethod();
    }
}
