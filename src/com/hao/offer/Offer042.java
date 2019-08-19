package com.hao.offer;

/**
 * 【面试题42】 【连续子数组的最大和】
 *  输入一个整型数组，数组里有**正数也有负数**。
 *  数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *  要求时间复杂度为O(n)。
 * @author hao
 *
 */
public class Offer042 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	 public static int FindGreatestSumOfSubArray(int[] array) {
	        return Solution1(array);
	 }

	private static int Solution1(int[] array) {
		if(array==null || array.length<=0) {
			return 0;
		}
		int curSum = 0;
		int maxSum = array[0];
		for(int i=0;i<array.length;i++) {
			if(curSum<=0) {
				curSum=array[i];
			}else{
				curSum+=array[i];
			}
			if(curSum>maxSum) {
				maxSum = curSum;
			}
		}
		return maxSum;
	}

	private static void test1() {
		int[] array ={6,-3,-2,7,-15,1,2,2};
		int maxSum = FindGreatestSumOfSubArray(array);
		System.out.println(maxSum);
	}

	private static void test2() {
	}
	private static void test3() {
	}
}