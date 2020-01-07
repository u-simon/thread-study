package com.simon.thread.thread.producerconsumer.queuemode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author simon
 * @Date 2020/1/4 3:00 下午
 */
public class ProdConsumer {

	public static void main(String[] args) throws InterruptedException {
		ShareSource shareSource = new ShareSource(new ArrayBlockingQueue<String>(10));

		new Thread(() -> {
			System.out.println("生产者线程启动");
			try {
				shareSource.producer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "producer").start();

		new Thread(() -> {
			System.out.println("消费者线程启动");
			try {
				shareSource.consumer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "consumer").start();


		TimeUnit.SECONDS.sleep(5);
		shareSource.stop(false);
		System.out.println("停止工作");
	}

}


class ShareSource {
	private volatile boolean FLAG = true;

	private AtomicInteger atomicInteger = new AtomicInteger();

	BlockingQueue<String> queue = null;

	public ShareSource(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void producer() throws Exception {
		String data = null;
		while (FLAG) {
			data = atomicInteger.incrementAndGet() + "";
			if (queue.offer(data, 2L, TimeUnit.SECONDS)) {
				System.out.println(Thread.currentThread().getName() + " 添加数据 " + data + " 成功");
			}

			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("公司倒闭 停止生产  flag = " + FLAG);
	}

	public void consumer() throws Exception {
		String poll = null;
		while (FLAG) {
			poll = queue.poll(2L, TimeUnit.SECONDS);
			if (poll == null || poll.equalsIgnoreCase("")) {
				System.out.println("仓库没有数据");
				return;
			}
			System.out.println(Thread.currentThread().getName() + " 消费数据 " + poll + " 成功");
		}
	}

	public void stop(boolean FLAG) {
		this.FLAG = FLAG;
	}
}
