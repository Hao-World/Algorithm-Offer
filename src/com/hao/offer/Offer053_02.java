package com.hao.offer;

/**
 * 【面试题53-2】 【0~n-1中缺失的数字】
 *  一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 *  在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 
 * @author hao
 *
 */
public class Offer053_02 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int GetMissingNumber(int[] array) {
		return Solution1(array);
	}

	

	private static int Solution1(int[] array) {
		if(array==null || array.length<=0) {
			return -1;
		}
		int start = 0;
		int end = array.length-1;
		
		while(start< end) {
			int mid = (start+end)>>1;
			if(array[mid]!=mid) {
				
				if(mid == 0 || array[mid-1]==mid-1) {
					return mid;
				}
				
				end = mid-1;
				
			}else {
				start = mid+1;
			}
		}
		
		return -1;
	}

	private static void test1() {
		int[] arr = {0,1,2,3,4,5,6,7,9,10,11};
		System.out.println(GetMissingNumber(arr));
	}

	private static void test2() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
		System.out.println(GetMissingNumber(arr));
	}
	private static void test3() {
		int[] arr = {0};
		System.out.println(GetMissingNumber(arr));
	}

}