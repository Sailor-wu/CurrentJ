package com.wd.costom;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wd.costom.MyAnnotation.MyAnno;

/**
 * desc 测试注解
 * @author wu
 * @date Create in 2019/05/25 10:20:53
 *
 */
public class TestMyAnno {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list,1,48,55,54,59,422);
		// 解析注解  传入使用注解的类
		trackMyAnno(list,UseAnno.class);
	}

	private static void trackMyAnno(List<Integer> list, Class<?> clazz) {
		// 获取类下面的所有方法
		for (Method m : clazz.getDeclaredMethods()) {
			
			//获取注解对象  根据传入的注解的类，获取类下对应的注解信息
			MyAnno anno = m.getAnnotation(MyAnno.class);
			if(anno != null) {
				System.out.println("找到注解信息："+anno.id()+"\t"+anno.description());
				list.remove(new Integer(anno.id()));
			}
		}
//		
//		for (Integer i : list) {
//			System.out.println("Warning: Missing use case-"+i);
//		}
	}
}
