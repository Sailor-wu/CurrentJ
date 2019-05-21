package com.wd.pipistream;

import java.io.PipedOutputStream;

/**
 * desc  输出管道流
 * @author wu
 * @date Create in 2019/05/21 15:51:55
 *
 */
public class WriteData {
	
	/**
	 * desc 输出管道流
	 * @param out
	 */
	public void writeMethod(PipedOutputStream out){
        try {
            System.out.println("write :");
//            for(int i=0;i<300;i++){
                String outData="这里是我的输出管道流信息。。。";
                out.write(outData.getBytes());
                System.out.print(outData);
//            }
            System.out.println();
            out.close();
        } catch (Exception e) {
            System.out.println("输出流异常！");
        }
    }
}
