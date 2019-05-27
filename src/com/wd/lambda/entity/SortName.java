package com.wd.lambda.entity;

import java.util.Arrays;
import java.util.Comparator;

/**
 * desc 排序
 * @author wu
 * @date Create in 2019/05/27 17:07:53
 *
 */
public class SortName {

	/**
	 * desc 默认之前的排序写法
	 * @param atp
	 */
	public static void sortName(String [] atp) {
		// 
		Arrays.sort(atp, new Comparator<String>() {

			/**
			 * 重写比较方法
			 */
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String[] atp = {"Zafael Nadal","Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"};
		for (String string : atp) {
			System.out.println("之前："+string);
		}
		// 重写排序方式
//		SortName.sortName(atp);
//		System.out.println("==========================");
		
		// 直接使用lambda expression方式处理
//		Comparator<String> sortName = (String s1,String s2) -> (s1.compareTo(s2));
//		Arrays.sort(atp,sortName);
		
		//简洁形式
		Arrays.sort(atp,(String s1,String s2) -> (s1.compareTo(s2)));
		
		
		System.out.println("==========================");
		for (String string : atp) {
			System.out.println("之后："+string);
		}
		
		
		
	}
}
