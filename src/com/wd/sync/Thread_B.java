package com.wd.sync;

/**
 * Thread_B
 * ??B
 */
public class Thread_B extends Thread{

    private SyncObject obj;

    public Thread_B(){

    }
    public Thread_B(SyncObject obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            this.obj.prevMethod(1);
            try {
                Thread.sleep(300);
                System.out.println(" ??  B:\t"+this.obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}