package com.hao.offer;

/**
 * 
 * 【面试题三】 【 题目一:找出数组中重复的数字。】
 * 
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * 
 * @author hao
 *
 */
public class Offer003_01 {
	public static void main(String[] args) {

		int[] arr = { 3, 5, 7, 8, 8, 6, 2, 4, 1 };
		int[] dupArr = new int[2];
		boolean duplicate = Offer003_01.duplicate(arr, dupArr);
		System.out.println(duplicate);
		System.out.println(dupArr[0]);
	}

	public static boolean duplicate(int[] arr, int[] dupArr) {
		return Solution1(arr, dupArr);
	}

	/**
	 * 
	 * 利用哈希表的思路扩展，重新排列数组
	 * @param numbers  要传递的数组
	 * @return   重复的数字
	 */
	public static boolean Solution1(int[] arr, int[] dupArr) {

		if (arr == null || arr.length <= 0) {// 判断数组是否为空
			return false;
		}
		for (int i = 0; i < arr.length; i++) {// 判断数组中的数据是否超出范围
			if (arr[i] < 0 || arr[i] > arr.length - 1) {
				return false;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i) {// 判断 当前元素与自身的下标i 是否相等 不相等的话进入循环
				if (arr[i] == arr[arr[i]]) {// 判断当前元素 和
					dupArr[0] = arr[i];
					return true;
				}
				// 目的是为了 使 a[0]=0;a[1]=1 a[2]=2; [2,3,2,1] 的话 a[0] = a[a[0]] =a[2] =2
				int temp = arr[i];
				arr[i] = arr[arr[i]];
				arr[temp] = temp;

			}
		}
		return false;
	}

}
