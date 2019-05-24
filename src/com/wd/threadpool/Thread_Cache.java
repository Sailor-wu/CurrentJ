package com.wd.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Thread_Cache {

	public void main1() {
		/**
		 * 1. 线程池执行流程 
		 * 			   提交任务
		 * 		        |
		 * 			 核心线程是否已满 --是--> 列队是否已满 --是--> 线程池是否已满 --是-->按照拒绝策略处理无法执行的任务 
		 * 				|				|	 				| 
		 * 				否  				否 					否
		 * 				| 				| 					|
		 * 			 创建线程执行任务 		任务入队列等待执行 		创建线程执行任务
		 * 
		 * 任务提交到线程池，会先判断当前线程是否小于corePoolSize 如果小于就创建线程来处理提交的任务
		 * 否则将任务放入workQueue（任务队列），如果队列满了 则判断当前线程数是否小于 maxmumPoolSize
		 * 如果小于则创建线程执行任务。否则就会调用handler，以表示线程池拒绝接受任务
		 * 
		 */

		ExecutorService service = Executors.newCachedThreadPool();

		service.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("执行任务。");
			}
		});
		// 结束
		service.shutdownNow();

	}

	// 任务队列
	private BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();

	//
	public void createThreadPool() {

		/**
		 * 1.创建定长线程池 特点：只有核心线程 & 不会被回收、线程数量固定、任务队列无大小限制（超出的线程任务会在队列中等待） 应用场景：控制线程最大并发数
		 */
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

		Runnable task;
		for (int i = 0; i < 100000; i++) {			
			// 2. 创建好Runnable类线程对象 & 需执行的任务
			task = new Runnable() {
				int time = 10;
				public void run() {
					while (time > 0) {					
						System.out.println(Thread.currentThread().getName()+":执行任务啦");
						time--;
					}
				}
			};
			// 2. 向线程池提交任务
			fixedThreadPool.execute(task);
		}

		/** shutdown：设置 线程池的状态 为 SHUTDOWN，然后中断所有没有正在执行任务的线程
   			shutdownNow：设置 线程池的状态 为 STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表
  			使用建议：一般调用shutdown（）关闭线程池；若任务不一定要执行完，则调用shutdownNow（）
		 */
		// 3.关闭线程池
		fixedThreadPool.shutdown();

	}
	
	/**
	 * desc 定时线程池
	 * 核心线程数量固定，非核心线程数无限制（限制自动回收）
	 * 应用场景： 执行定时/周期性  任务
	 */
	public void scheduleThreadPool() {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		
		// 2. 创建好Runnable类线程对象 & 需执行的任务
		Runnable task = new Runnable() {
			int time = 10;
			public void run() {
				while (time > 0) {					
					System.out.println(Thread.currentThread().getName()+":执行任务啦");
					time--;
				}
			}
		};
		// 2. 向线程池提交任务    task 任务   10 延迟多久开始执行     unit 事件单位
		service.schedule(task, 10, TimeUnit.SECONDS);
			
		service.shutdown();	
		
	}
	
	/**
	 * 1.只有非核心线程，线程数量不固定（可无限大 Integer.MAX_VALUE ）
	 * 2.灵活回收空闲线程（具备超时机制，全部回收时几乎不占用系统资源）
	 * 3.无线程可用直接新建
	 * 要注意： 3   可能无限制新建线程，相互竞争。及可能占用过多的系统资源导致死机或者OOM（内存溢出）
	 * 
	 * 任何线程任务到来都会立刻执行，不需要等待
	 * 应用场景：执行大量、耗时少的线程任务
	 */
	public  void cacheThreadPool() {
		// 1.创建缓存线程池
		ExecutorService service = Executors.newCachedThreadPool();
		
		// 2.创建Runnable  需要执行的任务
		Runnable task;
//		for (int i = 0; i < 1000000; i++) {			
			task= new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"\t：需要执行的任务");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			// 3.向线程池提交任务
			service.execute(task);
//		}
		
		// 4.关闭线程池
		service.shutdown();
	}
	
	/**
	 * desc 特点：只有一个核心线程（保证所有任务按照指定顺序在一个线程中执行，不需要处理线程同步的问题）
	 * .应用场景：不适合并发但可能引起IO阻塞性及影响UI线程响应的操作，如数据库操作，文件操作等
	 */
	public void singleThreadPool() {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		// 2. 创建好Runnable类线程对象 & 需执行的任务
		Runnable task;
		for (int i = 0; i < 10; i++) {			
			task = new Runnable() {
				int time = 10;
				public void run() {
					while (time > 0) {					
						System.out.println(Thread.currentThread().getName()+":执行任务啦=========:\t"+ time);
						time--;
					}
				}
			};
			service.execute(task);
		}

		service.shutdown();
	}
	
	public static void main(String[] args) {
		Thread_Cache cache = new Thread_Cache();
		cache.singleThreadPool();
	}
}
