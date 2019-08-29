package com.hao.offer;

import java.util.ArrayList;

/**
 * 【面试题57-1】 【和为S的两个数字】
 *  输入一个递增排序的数组和一个数字s,在数组中查找两个数，使得它们的和正好是s。
 *  如果有多对数字的和等于s,则输出任意一对即可。
 * 
 * @author hao
 *
 */
public class Offer057_01 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	 public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		return Solution1(array,sum);
	}


	private static ArrayList<Integer> Solution1(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array.length<2 || array==null) {
			return list;
		}
		
		int start = 0;
		int end = array.length-1;
	
		while(start < end) {
			int curSum = array[start] + array[end];
			if(curSum==sum) {
				
				list.add(array[start]);
				list.add(array[end]);
				return list;
			}else if(curSum < sum) {
				start++;
			}else {
				end--;
			}
		}
		
		return list;
	
	}

	private static void test1() {
	}

	private static void test2() {

	}
	private static void test3() {

	}

}