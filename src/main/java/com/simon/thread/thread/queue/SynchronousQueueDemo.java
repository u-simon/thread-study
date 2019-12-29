package com.simon.thread.thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author simon
 * @Date 2019/12/29 4:22 下午
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        /**
         * SynchronousQueue
         *  不存储元素的队列, 当放入一个元素的时候 只有这个元素被取走消费 才会放入第二个元素
         *  相当远容量为1的ArrayBlockQueue
         */
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>(false);

        new Thread(()->{
            try {
                System.out.println( Thread.currentThread().getName() + " put 1 " );
                blockingQueue.put("1");

                System.out.println( Thread.currentThread().getName() + " put 2 " );
                blockingQueue.put("2");

                System.out.println( Thread.currentThread().getName() + " put 3 " );
                blockingQueue.put("3");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5L);
                System.out.println(blockingQueue.take());

                TimeUnit.SECONDS.sleep(5L);
                System.out.println(blockingQueue.take());

                TimeUnit.SECONDS.sleep(5L);
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();

    }
}
