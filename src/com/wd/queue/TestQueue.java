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

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		
		//  20秒之后，停止生产和消费
		Thread.sleep(120000);
		service.shutdownNow();
	}
}
