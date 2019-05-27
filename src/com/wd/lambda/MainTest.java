package com.wd.lambda;

import java.util.Arrays;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
//		
//		() -> 5 ;  				不需要参数，返回值为5 
//		x -> 2 * x; 			接受一个参数，返回其2倍的值
//		(x,y) -> x - y			接受两个参数，返回他们的差值
//		(int x,int y) -> x+y	接受两个int参数，返回他们的和

		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"};  
		List<String> players =  Arrays.asList(atp);  
//		  
//		// 以前的循环方式  
//		for (String player : players) {  
//		     System.out.println(player + "; ");  
//		}  
//		  System.out.println("=============1111=================");
//		// 使用 lambda 表达式以及函数操作(functional operation)  
//		players.forEach((player) -> System.out.println(player + "; "));  
//		System.out.println("============123123=================="); 
//		// 在 Java 8 中使用双冒号操作符(double colon operator)  
//		players.forEach(System.out::println);
		
//		players.forEach((player) -> System.out.println(player));
		
		players.forEach(System.out:: println);
		
		
	}

}
