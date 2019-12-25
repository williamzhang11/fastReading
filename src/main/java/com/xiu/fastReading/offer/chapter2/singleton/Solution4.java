package com.xiu.fastReading.offer.chapter2.singleton;

public class Solution4 {

	private Solution4() {
		
	}
	
	
	private static Solution4 solution4 = new Solution4();
	
	public static Solution4 getInstance() {
		
		return solution4;
	}
}
