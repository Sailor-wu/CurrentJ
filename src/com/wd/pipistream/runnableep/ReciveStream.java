package com.wd.pipistream.runnableep;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * . 接受管道信息
 * @author wu
 * @date Create in 2019/05/21 16:16:34
 *
 */
public class ReciveStream implements Runnable {
	
	private PipedInputStream inputStream;
	
	public ReciveStream() {
		this.inputStream = new PipedInputStream();
	}

	@Override
	public void run() {
		// 接受内容
		try {
			byte [] bytearr = new byte[2048];
			int len = this.inputStream.read(bytearr);
			
			System.out.println("读取到的信息："+new String(bytearr, 0,len));
			
			this.inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public PipedInputStream getInputStream() {
		return this.inputStream;
	}

	
}
