package com.simon.thread.thread.mutilethread;

/**
 * @Author simon
 * @Date 2019-08-26 21:58
 */
public class Run {


    public static void main(String[] args) {
        PrintString printString = new PrintString();
//        printString.printStringMethod();
//        new Thread(printString).start();
//        System.out.println("我要停止他！ stop Thread ：" + Thread.currentThread().getName());
//        printString.setContinuePrint(false);


        RunThread runThread = new RunThread();
        runThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        runThread.setRunning(false);
        System.out.println("已经复制为false");

    }
}
