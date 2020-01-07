package com.simon.thread.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author simon
 * @Date 2020/1/7 9:41 下午
 */
public class TestHarness {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(1);

		CountDownLatch endGate = new CountDownLatch(10);

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					latch.await();
					// 执行测试代码

                    TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {

				} finally {
					endGate.countDown();
				}
			}).start();
		}

		long start = System.currentTimeMillis();
		latch.countDown();
		endGate.await();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
