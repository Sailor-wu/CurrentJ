package com.wd.queue;

/**
 * desc 生产者，负责生产
 * 			无止休生产，间隔是一秒一个
 * @author wu
 * @date Create in 2019/05/23 16:51:10
 *
 */
public class Producer implements Runnable{

	Container ins = Container.getInstance();
	
	@Override
	public void run() {
		
		while (true) {
			System.out.println("准备生产....下次生产在一秒后！...");
			ins.produce();
			System.out.println("=====生产完毕   ！ =====共有"+ins.getSize()+"个！====");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
