package com.hao.offer;

/**
 * 【面试题53-03】 【数组中数值和下标相等的元素】
 *  假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数，
 *  找出数组中任意一个数值等于其下标的元素。
 *  例如，在数组{-3,-1, 1,3,5}中，数字3和它的下标相等。
 * 
 * @author hao
 *
 */
public class Offer053_03 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int GetNumberSameAsIndex(int[] array) {
		return Solution1(array);
	}

	
	private static int Solution1(int[] array) {
		if(array==null || array.length<=0) {
			return -1;
		}
		int left = 0;
		int right = array.length-1;
		while(left<=right) {
			int mid = (left+right)>>1;
			if(array[mid]>mid) {
				right = mid-1;
			}else if(array[mid]<mid){
				left = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

	private static void test1() {
		int[] array = {-3,-1, 1,3,5};
		System.out.println(GetNumberSameAsIndex(array));
	}

	private static void test2() {
		int[] array = {0,1,2,3,4,5};
		System.out.println(GetNumberSameAsIndex(array));
	}
	private static void test3() {
		int[] array = {0};
		System.out.println(GetNumberSameAsIndex(array));
	}

}