package com.hao.offer;

import java.util.ArrayList;

/**
 * 【面试题40】 【最小的K个数】 输入n个整数，找出其中最小的k个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 
 * @author hao
 *
 */
public class Offer040 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		return Soltuion2(input, k);
	}

	/**
	 * partition的思路： 利用Partition 第k个位置的分界线，左边的值比第k个位置的值小，右边的比它大， 那么，左边的k个数就是所要求的值
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	private static ArrayList<Integer> Soltuion1(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input == null || input.length < 0 || k <= 0 || k > input.length) {
			// 这里要判断k的取值
			return list;
		}
		int low = 0;
		int high = input.length - 1;
		int index = Partition(input, low, high);

		while (index != k - 1) {
			if (index < k - 1) {
				low = index + 1;
				index = Partition(input, low, high);
			} else {
				high = index - 1;
				index = Partition(input, low, high);
			}
		}
		for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}
		return list;
	}

	private static int Partition(int[] input, int low, int high) {
		int pivot = input[low];
		while (low < high) {
			while (low < high && input[high] >= pivot)
				high--;
			input[low] = input[high];
			while (low < high && input[low] <= pivot)
				low++;
			input[high] = input[low];
		}
		input[low] = pivot;
		return low;
	}
	
	/**
	 * 思路二：
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	private static ArrayList<Integer> Soltuion2(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input == null || input.length < 0 || k <= 0 || k > input.length) {
			// 这里要判断k的取值
			return list;
		}
		int[] numbers = new int[k];
		for(int i=0;i<k;i++) {
			numbers[i]=input[i]; //放入前k个数
		}
		for(int i=k/2-1;i>=0;i--) {
			adjustDown(numbers,i); //向下调整大顶堆
		}
		
		for(int i =k;i<input.length;i++) {
			if(input[i]<numbers[0]) {
				numbers[0] = input[i];
				adjustDown(numbers, 0);
			}
			
		}
		
		for (int num : numbers) {
			list.add(num);
		}
 		return list;
	}

	private static void adjustDown(int[] numbers, int k) {
		int tmp = numbers[k];//保存要调整的值
		for(int i=k*2+1;i<=numbers.length-1;i=i*2+1) {//因为k要遍历到索引0,索引需要+1
			
			if(i<numbers.length-1 && numbers[i]<numbers[i+1]) {
				i++; //将i的索引指向左右子节点中最大的值
			}
			if(tmp>=numbers[i]) break; // 如果要调整的值大于它左右子节点中最大的数，就不需要调整了
			else {
				numbers[k] = numbers[i];//与最大的值交换
				k=i;//修改k值，继续向下调整
			}
		}//for
		numbers[k] = tmp; //被筛选的值放入最终位置
	}

	private static void test1() {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		ArrayList<Integer> list = GetLeastNumbers_Solution(input, 4);
		System.out.println(list);
	}

	private static void test2() {

	}

	private static void test3() {

	}

}