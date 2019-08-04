package com.hao.offer;

/**
 * 【面试题三】
 * 【题目二:不修改数组找出重复的数字。】
 * 
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，
 * 那么对应的输出是重复的数字2或者3。
 * @author hao
 *
 */
public class Offer003_02 {
	public static void main(String[] args) {
		int[] arr = {1,9,4,4,3,2,6,7,7};
		int dupNum = Offer003_02.getDuplication(arr);
		System.out.println(dupNum);
	}
	
	public static int getDuplication(int[] arr) {
		return Solution1(arr);
	}
	
	/**
	 * 由于题目中说明 数组长度为n+1,而数组中数字的范围为1~n, 这就说明数组中一定存在重复的数字
	 * 将数字1 ~ n 切成两半：1 ~ m  、  m+1 ~n 
	 * 可以判断 数组中数字在两个 范围中出现的次数，
	 * 如果出现的次数大于 m ， 则说明 重复的数字在1 ~ m 之间，否则，m+1 ~ n之间
	 * 
	 * 类似于二分查找的方法
	 * 
	 * @param arr
	 * @return
	 */
	private static int Solution1(int[]arr) {
		if(arr==null || arr.length<=0) {
			return -1;
		}
		int start = 1;
		int end = arr.length-1;
		while(end>=start) {
//			int middle = ((end-start)>>1) + start;
			int middle = (end+start)>>1;
			int count = getCount(arr,start,middle);
			if(end==start) {
				if(count > 1) {
					return start;
				}else {
					break;
				}
			}
			
			if(count > (middle-start)+1) {
				end = middle;
			}else {
				start = middle+1;
			}
		}
		return -1;
	}
	
	
	/**
	 * 判断 arr  在start 和end 范围 内 有多少个元素
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getCount(int[] arr, int start, int end) {
		if(arr==null) {
			return 0;
		}
		int count = 0;
		for(int i=0;i< arr.length;i++) {
			if(arr[i]>=start&& arr[i]<=end) {
				++count;
			}
		}
		return count;
	}
	
}
