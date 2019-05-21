package com.wd.waitT;

import java.util.ArrayList;
import java.util.List;

/**
 * SyncObject
 * 共享对象
 * 线程操作集合
 */
public class SyncObject {

	/** 共享對象集合*/
	private static List<String> list = new ArrayList<String>();

    public static void add() {
        list.add("节点------");
    }

    public static int size() {
        return list.size();
    }
}