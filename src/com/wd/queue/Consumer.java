package com.wd.queue;

/**
 * desc 消费者
 * 		无止休消费
 * @author wu
 * @date Create in 2019/05/23 16:59:13
 *
 */
public class Consumer implements Runnable{

	Container ins = Container.getInstance();
	@Override
	public void run() {
		System.out.println("===========消费者开始消费==========");
		try {
			String takeStr = ins.takeStr();
			System.out.println("===========消费者消费了："+takeStr+"=====剩下："+ins.getSize()+"个！ =====");
			System.out.println("下次消费是二秒后！");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
