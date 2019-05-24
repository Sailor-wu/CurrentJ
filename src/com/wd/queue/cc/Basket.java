package com.wd.queue.cc;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Basket {

	// 篮子，容器
	BlockingQueue<String> basket = new ArrayBlockingQueue<String>(10);

	// 生产字符串，放入篮子
	public void produce() throws InterruptedException {
		// put方法放入一个字符串，若basket满了，等到basket有位置
		System.out.println("生产："+getRandomString(5));
		basket.put(getRandomString(5));
	}

	// 消费字符串，从篮子中取走
	public String consume() throws InterruptedException {
		// get方法取出一个字符串，若basket为空，等到basket有字符串为止
		String apple = basket.take();
		return apple;
	}

	public int getSize() {
		return basket.size();
	}

	/**
	 * 用户要求产生字符串的长度
	 * 
	 * @param length 长度
	 * @return
	 */
	public static String getRandomString(int length) {
		String str = "abcdefghjkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ023456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
}
