package com.wd.waitT;

/**
 * Thread_B
 */
public class Thread_B extends Thread{

    private Object obj;

    public Thread_B(){

    }
    public Thread_B(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
    	try {			
    		synchronized (obj) {
    			for (int i = 0; i < 10; i++) {
    				SyncObject.add(); // 添加节点
    				// 判断节点是否等于5 等于就通知线程A 执行
    				if(SyncObject.size() == 5) {
    					System.out.println("*********");
    					//唤醒其他线程
    					obj.notify();
    					//自己放弃cpu 等待唤醒
    					obj.wait();
    				}
    				System.out.println("添加了 \t"+SyncObject.size()+"个节点！");
    				Thread.sleep(1500);
    			}
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}