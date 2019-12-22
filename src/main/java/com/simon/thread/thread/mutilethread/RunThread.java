package com.simon.thread.thread.mutilethread;

/**
 * @Author simon
 * @Date 2019-08-26 22:05
 */
public class RunThread extends Thread {
    private volatile boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (running){

        }
        System.out.println("线程被停止了");
    }
}
