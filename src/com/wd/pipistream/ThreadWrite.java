package com.wd.pipistream;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {

	
	/** 输出管道流*/
	WriteData write;
    
    PipedOutputStream out;
    
    public ThreadWrite(WriteData write,PipedOutputStream out){
        this.write=write;
        this.out=out;
    }
    @Override
    public void run(){
        write.writeMethod(out);
    }

}
