package com.hao.offer;

/**
 * 【面试题39】 【数组中出现次数超过一半的数字】 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如，输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 
 * @author hao
 *
 */
public class Offer39 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static int MoreThanHalfNum_Solution(int[] array) {
		return Solution2(array);
	}

	/**
	 * partition方法
	 * 
	 * @param array
	 * @return
	 */
	private static int Solution1(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int middle = array.length >> 1;
		int low = 0;
		int high = array.length - 1;
		int index = partition(array, low, high);
		while (index != middle) {
			if (index < middle) {
				low = index + 1;
				index = partition(array, low, high);
			} else {
				high = index - 1;
				index = partition(array, low, high);
			}
		}

		int result = array[middle];
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if (result == array[i]) {
				times++;
			}
		}

		if (times * 2 > array.length) {
			return result;
		}
		return 0;
	}

	private static int partition(int[] array, int low, int high) {
		int privot = array[low];
        while(low<high){
            while(low<high && array[high]>=privot) high--;
            array[low] = array[high];
            while(low<high && array[low]<=privot) low++;
            array[high] = array[low];
        }
        array[low] = privot;
        return low;
	}

	private static int Solution2(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int count = 1;
		int flagNum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (count == 0) {
				flagNum = array[i];
				count = 1;
			} else if (array[i] == flagNum) {
				count++;
			} else {
				count--;
			}
		}
		if (count > 0) {
			int times = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == flagNum) {
					times++;
				}
			}
			if (times * 2 > array.length) {
				return flagNum;
			}
		}
		return 0;
	}

	private static void test1() {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		int result = MoreThanHalfNum_Solution(array);
		System.out.println(result);
	}

	private static void test2() {
		int[] array = { 1 };
		int result = MoreThanHalfNum_Solution(array);
		System.out.println(result);
	}

	private static void test3() {
		int[] array = {};
		int result = MoreThanHalfNum_Solution(array);
		System.out.println(result);
	}
}