package com.wd.lambda.entity;

/**
 * desc lambdas实现接口的实例
 * @author wu
 * @date Create in 2019/05/27 16:56:38
 *
 */
public class LambdasInterface {

	public static void main(String[] args) {
		// 正常写法
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// 执行操作
				System.out.println("执行操作。。。。");
			}
		}).start();
		
		// lambdas 写法
		new Thread(() -> System.out.println("执行操作............")).start();
		// 直接把要操作的数据等信息，封装在 {  }里面
//		Runnable race2 = () -> System.out.println("sssss");
		Runnable race2 = () -> {int num = 10; while (num>0) {System.out.println("shixing -----"+num); num--;}};
		race2.run();
		
		
		
	}
}
