package com.hao.offer;

import java.util.Arrays;

/**
 * 【面试题21】 【调整数组顺序使奇数位于偶数前面】
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分， 所有的偶数位于数组的后半部分
 * 
 * @author hao
 *
 */
public class Offer21 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	public static void reOrderArray(int[] array) {
		Solution2(array);
	}

	
	/**
	 * 这种方法会打乱偶数之间 奇数之间的相对顺序(题目中并没有要求)
	 * 思路，利用快速排序中思想
	 * @param array
	 */
	private static void Solution1(int[] array) {
		if(array == null || array.length<=0) {
			throw new IllegalArgumentException("参数非法!");
		}
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			while (i < j && !isEven(array[i])) {//如果是奇数i下标后移，直到指向偶数
				i++;
			}
			while (i < j && isEven(array[j])) {//如果是偶数j 下标前移，直到指向奇数
				j--;
			}
			if (i < j) {
				int tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
			}
		}
	}

	/**
	 * 当题目中要求要保持偶数之间 奇数之间的相对顺序时，
	 * 就需要用到这种方法
	 * 思路：插入排序的思想
	 * @param array
	 */
	private static void Solution2(int[] array) {
		if(array==null) {
			throw new IllegalArgumentException("参数非法!");
		}
		int j,tmp;
		for(int i=1;i<array.length;i++) {
			if(!isEven(array[i])) {
				tmp = array[i];	
				//此处j>=0的条件要放在前面 
				for(j=i-1; j>=0 && isEven(array[j]);j--) {
					array[j+1] = array[j];
				}
				array[j+1] = tmp;
				
//				这种方式 也行
//				j=i;
//				while(j>0 && isEven(array[j-1])) {
//					array[j] = array[j-1];
//					j--;
//				}
//				array[j] = tmp;
				
			}
		}
	}
	
	
	private static boolean isEven(int number) {
		return (number & 1) == 0;
	}

	private static void test1() {
		int[] array = { -1, 9, 5, 2, 10, 6 };
		System.out.println("原始数组：" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("调整结果：" + Arrays.toString(array));
		System.out.println();
	}
	
	private static void test2() {
		int[] array = { 2,10,8, 9,-7,17};
		System.out.println("原始数组：" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("调整结果：" + Arrays.toString(array));
		System.out.println();
	}

	private static void test3() {
		int[] array = { 2};
		System.out.println("原始数组：" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("调整结果：" + Arrays.toString(array));
		System.out.println();
	}
	
	private static void test4() {
		int[] array = null;
		reOrderArray(array);
	}
}
