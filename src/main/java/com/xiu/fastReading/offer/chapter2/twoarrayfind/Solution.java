package com.xiu.fastReading.offer.chapter2.twoarrayfind;

/**
 * 
 * @author william
 * 
 * 数组中查找关键是，每一步缩小查找范围
 * 
 * 从右上角（或左下角）开始查找，如果该数字大于要查找的数字，则向左移动，如果该数字小于要查找的数字，则向下移动
 * 如果相等返回
 *
 */
public class Solution {
	
	public static Boolean find(int array[][],int target) {
		
		//初始化
		int i = array.length -1;
		int j = array[0].length -1;
		
		int begin_i = 0;
		int begin_j = j;
		
		//校验
		if(array.length ==0 && array[0].length==0) {
			return false;
		}
		
		//查找
		while(begin_i <= i && begin_j >= 0) {
			
			if(array[begin_i][begin_j] ==target) {
				return true;
			}
			
			if(array[begin_i][begin_j] >target) {
				begin_j--;
			}else {
				begin_i++;
			}
			
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int [][] array = {{1,2,8,9},{2,4,9,12},{3,6,10,13},{4,8,11,14}};
		
		System.out.println(find(array, 0));
		
	}

	
}
