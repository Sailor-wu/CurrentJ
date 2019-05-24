package com.wd.queue.cc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Container {
	
	public void queueMethod() {
		// 建立一个装字符串的篮子
		final Basket basket =new Basket();
		// 定义字符串生产者
		class Producer implements Runnable {
			public void run() {
				try {
					while (true) {
						// 生产字符串
						System.out.println("生产者准备生产");
						basket.produce();
						System.out.println("生产者生产字符串完毕"  );
						System.out.println("生产完后有：" + basket.getSize() + "个");
						// 休眠300ms
						Thread.sleep(300);
					}
				} catch (InterruptedException ex) {
				}
			}
		}
		// 定义字符串消费者
		class Consumer implements Runnable {
			public void run() {
				try {
					while (true) {
						// 消费字符串
						System.out.println("消费者准备消费字符串");
						String takeStr = basket.consume();
						System.out.println("消费者消费字符串完毕："+takeStr );
						System.out.println("消费完后有字符串：" + basket.getSize() + "个");
						// 休眠1000ms
						Thread.sleep(1000);
					}
				} catch (InterruptedException ex) {
				}
			}
		}

		ExecutorService service = Executors.newCachedThreadPool();

		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		// 程序运行20s后，所有任务停止
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		service.shutdownNow();

	}
	
	public static void main(String[] args) {
		new Container().queueMethod();
	}
}
