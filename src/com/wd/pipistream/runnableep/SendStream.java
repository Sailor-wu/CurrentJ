package com.wd.pipistream.runnableep;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * desc 管道输出流  发送
 * @author wu
 * @date Create in 2019/05/21 16:13:39
 *
 */
public class SendStream implements Runnable {

	// 输出信息
	private String writeMessage;
	// 管道输出流
	private PipedOutputStream outStream;
	
	public SendStream() {
		this.outStream = new PipedOutputStream();
	}
	
	/**
	 * desc 获取输出流
	 * @return
	 */
	public PipedOutputStream getOutStream() {
		return outStream;
	}


	/**
	 * desc 
	 */
	@Override
	public void run() {
		try {
			this.outStream.write(this.writeMessage.getBytes());
			this.outStream.close();
			System.out.println("管道流输出信息完毕："+this.writeMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * .获取输出信息
	 * @return
	 */
	public String getWriteMessage() {
		return writeMessage;
	}
	public void setWriteMessage(String writeMessage) {
		this.writeMessage = writeMessage;
	}
	
	
	
	
	

}
