package com.wd.sync;

/**
 * Thread_A
 * 线程A
 */
public class Thread_A extends Thread{

    private SyncObject obj;
    public Thread_A(){

    }
    public Thread_A(SyncObject obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            this.obj.addMethod(1);
            try {
                Thread.sleep(300);
                System.out.println("线程  A:\t"+this.obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}