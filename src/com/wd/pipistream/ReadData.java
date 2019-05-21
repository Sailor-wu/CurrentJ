package com.wd.pipistream;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * desc 读取管道数据流
 * @author wu
 * @date Create in 2019/05/21 15:43:40
 *
 */
public class ReadData {

	/**
	 * desc 读取输入流
	 * @param inputStream
	 */
	public void pipeInputStream(PipedInputStream inputStream) {
		try {
			System.out.println("正在读取管道数据：");
			// 缓存区
			byte  [] byarr = new byte[100];
			int read = inputStream.read(byarr);
			while (read != -1) {
				// 组装
				String newData = new String(byarr,0 ,read);
				System.out.println("read mess:\t"+newData);
				read = inputStream.read(byarr);
			}
			System.out.println();
			// 关闭流
			inputStream.close();
		} catch (IOException e) {
			System.out.println("读取管道流异常！");
		}
	}
}
