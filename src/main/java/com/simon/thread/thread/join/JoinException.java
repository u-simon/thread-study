package com.simon.thread.thread.join;

/**
 * @Author simon
 * @Date 2019-10-22 21:18
 */
public class JoinException {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(()->{
            for (int i = 0; i < Integer.MAX_VALUE; i++){
                Math.random();
            }
        });

       Thread threadB =  new Thread(()->{
           threadA.start();
            try {
                threadA.join();
                System.out.println("线程b在run end处打印了");
            } catch (InterruptedException e) {
                System.out.println("线程b在catch处打印了");
                e.printStackTrace();
            }
        });

        threadB.start();
        Thread.sleep(500);

        threadB.interrupt();

    }
}
