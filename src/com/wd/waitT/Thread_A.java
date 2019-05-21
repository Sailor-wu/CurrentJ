package com.wd.waitT;

/**
 * Thread_A 线程A
 * 创建线程，等待条件满足。等待通知在执行
 */
public class Thread_A extends Thread {

	private Object obj;

	public Thread_A() {

	}

	public Thread_A(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		super.run();
		try {
			synchronized (obj) {
				if (SyncObject.size() != 5) {
					System.out.println("wait begin " + System.currentTimeMillis());
					obj.wait();
					System.out.println("wait end  " + System.currentTimeMillis());
				}
				// 执行完毕后在唤醒其他等待线程
				Thread.sleep(1000);
				System.out.println("睡眠了一秒，唤醒等待线程。");
				obj.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}