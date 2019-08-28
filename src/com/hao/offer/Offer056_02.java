package com.hao.offer;

/**
 * 【面试题56-2】 【数组中唯一只出现一次的数字】
 *  　在一个数组中除一个数字只出现一次之外，其他数字都出现了**三次**。请找出那个只出现一次的数字
 * 
 * @author hao
 *
 */
public class Offer056_02 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int findNumberAppearingOnce(int[] array) {
		return Solution1(array);
	}


	private static int Solution1(int[] array) {
		if(array==null || array.length<=0) {
			return -1;
		}
		
		int[] bitSum = new int[32];
		for(int i=0;i<array.length;i++) {
			int bitMask = 1;
			for(int j=31;j>=0;j--) {//将每个数字的每一位存储到bitSum中，并且对应的位相加
				int bit = array[i] & bitMask;
				if(bit!=0) {
					bitSum[j]+=1;
				}
				bitMask = bitMask<<1;
			}
		}
		
		int result =0;
		for(int i=0;i<32;i++) {
			result = result<<1;
			result += bitSum[i]%3;
		}
		
		return result;
	}

	private static void test1() {
		int[] array = {1,1,1,4,5,4,4,2,2,2};
		System.out.println(findNumberAppearingOnce(array)); 
	}

	private static void test2() {

	}
	private static void test3() {

	}

}