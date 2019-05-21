package com.wd.pipistream;
/**
 * desc 输入管道流
 * @author wu
 * @date Create in 2019/05/21 15:59:18
 *
 */

import java.io.PipedInputStream;

public class ThreadRead extends Thread {

	/** 输入流 */
	ReadData readData;
	
	PipedInputStream inputStream;
	
	public ThreadRead(ReadData readData,PipedInputStream stream) {
		this.readData = readData;
		this.inputStream = stream;
	}

	@Override
	public void run() {
		readData.pipeInputStream(inputStream);
	}
	
	
	
}
