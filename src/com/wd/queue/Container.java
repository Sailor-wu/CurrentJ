package com.wd.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * desc 容器 生產方
 * 
 * @author wu
 * @date Create in 2019/05/23 16:25:23
 *
 */
public class Container {

	/*单例模式  容器只有一个*/
	private static final Container ins = new Container();
	public static Container getInstance() {
		return ins;
	}
	private Container() {
	}
	/**
	 * ArrayBlockingQueue在构造时需要指定容量，
	 * 并可以选择是否需要公平性，如果公平参数被设置true，等待时间最长的线程会优先得到处理
	 * （其实就是通过将ReentrantLock设置为true来达到这种公平性的：即等待时间最长的线程会先操作）。
	 * 通常，公平性会使你在性能上付出代价，只有在的确非常需要的时候再使用它。它是基于数组的阻塞循环队列，此队列按 FIFO（先进先出）原则对元素进行排序。
	 */
	public BlockingQueue<String> rongQi = new ArrayBlockingQueue<String>(10, false);
	
	/**
	 * 生产对象，放在容器里面
	 * 这里生产字符串
	 */
	public  void produce() {
		try {
			//  put 方法放入一个字符串，如果容器满了，等待位置
			String randomString = getRandomString(5);
			System.out.println("生产了：\t"+randomString);
			rongQi.put(randomString);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * desc 消费容器字符串
	 * @return
	 * @throws InterruptedException
	 */
	public String takeStr() throws InterruptedException {
		// 取，如果容器为空，等待有字符串
		return rongQi.take();
	}
	
	/**
	 * 获取容器的容量
	 */
	public int getSize() {
		
		return rongQi.size();
	}
	
	
	
	/**
	 * 用户要求产生字符串的长度
	 * @param length 长度
	 * @return
	 */
	 public static String getRandomString(int length){
	     String str="abcdefghjkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ023456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}
