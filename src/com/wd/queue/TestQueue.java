package com.wd.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc 测试队列类
 * @author wu
 * @date Create in 2019/05/23 16:50:26
 *
 */
public class TestQueue {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
//		Thread.sleep(100);
		service.submit(consumer);
		
		//  20秒之后，停止生产和消费
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.shutdownNow();
	}
}
