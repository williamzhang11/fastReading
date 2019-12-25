package com.xiu.fastReading.offer.chapter2.singleton;

/**
 * 线程不安全，只能在单线程下使用
 * 构造函数私有化，避免重复创建
 * @author william
 *
 */
public class Solution1 {

	
	private Solution1() {
		
	}
	
	
	private static Solution1 instance =null;
	
	public Solution1 getInstance() {
		
		if(instance == null) {
			instance = new Solution1();
		}
		
		return instance;
	}
}
