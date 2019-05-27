package com.wd;

import com.wd.waitT.SyncObject;
import com.wd.waitT.Thread_A;
import com.wd.waitT.Thread_B;

/**
 * desc 启动测试类
 * @author wu
 * @date Create in 2019/05/21 14:32:54
 *
 */
public class StartApp {

	public static void main(String[] args) {
		/**
		 * 由于线程A 和    B 都同时持有 obj对象，尽管这两个线程需要调用不同的方法，
		 * 但是它们是同步执行的，比如：线程B需要等待线程A执行完了methodA()方法之后，它才能执行methodB()方法。
		 * 这样，线程A和线程B就实现了 通信。
		 * 这种方式，本质上就是“共享内存”式的通信。
		 * 多个线程需要访问同一个共享变量，谁拿到了锁（获得了访问权限），谁就可以执行。
		 */
//		SyncObject object = new SyncObject();
//		Thread_A a = new Thread_A(object);
//		a.start();
//		
//		Thread_B b = new Thread_B(object);
//		b.start();
		
		//**********************************************************
		Object object = new Object();
		try {
			Thread_A a = new Thread_A(object);
			a.start();
			//  停止一会 确保A线程已经是处于wait状态
			Thread.sleep(50);
			// 创建 B 线程来唤醒A 线程
			Thread_B b = new Thread_B(object);
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
