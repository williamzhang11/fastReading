package com.xiu.fastReading.offer.chapter2.singleton;

public class Solution2 {

	private Solution2() {
	}
	
	private static Solution2 solution2 = null;

	public synchronized static Solution2 getInstance() {
		
		if(solution2 == null) {
			solution2 = new Solution2();
		}
		
		return solution2;
		
	}
}
