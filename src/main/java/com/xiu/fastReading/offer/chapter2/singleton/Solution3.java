package com.xiu.fastReading.offer.chapter2.singleton;

import java.io.ObjectInputStream.GetField;

public class Solution3 {

	private Solution3() {
		
	}
	
	private static Object syncObjecct = new Object(); 
	private static volatile Solution3 solution3 = null;
	
	public Solution3 getInstance() {
		
		if(solution3 == null) {
			synchronized (syncObjecct) {
				if(syncObjecct == null) {
					solution3 = new Solution3();
				}
			}
			
		}
		
		return solution3;
		
	}
}
