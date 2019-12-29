package com.simon.thread.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author simon
 * @Date 2019/12/29 3:53 下午
 */
public class QueueDemo {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

		/**
		 * 抛出异常的一组
         *  add java.lang.IllegalStateException: Queue full队列满了会抛出异常
         *  remove java.util.NoSuchElementException 队列空的时候回抛出异常
         *  element
		 */
		blockingQueue.add("a");
		blockingQueue.add("b");
		blockingQueue.add("c");

		// java.lang.IllegalStateException: Queue full队列满了会抛出异常
		// blockingQueue.add("d");

		// 判断队列中队首元素
		System.out.println(blockingQueue.element());

		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
		//
		// System.out.println(blockingQueue.remove());

        System.out.println("---------------");
		/**
		 * 特殊值的一组
         *  offer 当队列满的时候 返回失败false
         *  peek 判断队列中队首元素
         *  poll 当队列为空的时候 返回Null
		 */
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());


        /**
         * 阻塞的一组
         *  put
         *  take
         */

        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        System.out.println("==========");
        //blockingQueue.put("a");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());


        System.out.println("----------");

        /**
         * 带超时时间的
         *  offer(e, time, unit)
         *  poll(time, unit)
         */

        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));


    }
}
