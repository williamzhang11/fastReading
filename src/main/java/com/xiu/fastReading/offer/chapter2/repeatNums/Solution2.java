package com.xiu.fastReading.offer.chapter2.repeatNums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution2 {

	public List<Integer> solve(int[] array) {
		
		
		List<Integer> list = new ArrayList<Integer>();
		if(array.length <=1) return list;
		
		Set<Integer> set = new HashSet<Integer>();

		
		for(int ele : array) {
			
			if(set.contains(ele)) {
				list.add(ele);
			}else {
				set.add(ele);
			}
		}
	
		return new ArrayList<Integer>(new HashSet<Integer>(list));
	}
	
	public static void main(String[] args) {
		int [] array = {6,6,6,4};
		System.out.println(new Solution1().deal(array));
	}
}
