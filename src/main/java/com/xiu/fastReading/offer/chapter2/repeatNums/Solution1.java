package com.xiu.fastReading.offer.chapter2.repeatNums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution1 {

	public List<Integer> deal(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		if(array.length <=1) return list;
		
		int length = array.length;
		Arrays.sort(array);
		
		for(int i = 1; i<length;i++) {
			
			if(array[i-1] == array[i]) {
				list.add(array[i]);
			}
		}
		
		
		return new ArrayList<Integer>(new HashSet<Integer>(list));
	}
	
	public static void main(String[] args) {
		
		int [] array = {6,1,3,4,6,6};
		System.out.println(new Solution1().deal(array));
	}
}
