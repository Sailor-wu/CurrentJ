package com.wd.pipistream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class StartMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		WriteData writeData=new WriteData();
        ReadData readData=new ReadData();
        PipedInputStream input=new PipedInputStream();
        PipedOutputStream out=new PipedOutputStream();
        ThreadWrite threadWrite=new ThreadWrite(writeData, out);
        ThreadRead threadRead=new ThreadRead(readData, input);
        
        // 连接管道
        out.connect(input);
        
        
        threadRead.start();
        Thread.sleep(2000);
        threadWrite.start();
        
        
	}
}
