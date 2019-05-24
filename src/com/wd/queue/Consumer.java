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

		try {
//			if(Thread.currentThread().isInterrupted()){  
//                System.out.println("Someone interrupted me.");
//                Thread.currentThread().wait();
//            }else{  
            	System.out.println("===========消费者开始消费==========");
                String takeStr = ins.takeStr();
                System.out.println("===========消费者消费了："+takeStr+"=====剩下："+ins.getSize()+"个！ =====");
                Thread.currentThread().notifyAll();
                Thread.sleep(1000);
//            }
		} catch (InterruptedException e) {
			
		}
	}
}
