package com.hao.offer;

import java.util.ArrayList;

/**
 * 【面试题57-2】 【和为S的连续正数序列】 模版
 * 
 * @author hao
 *
 */
public class Offer057_02 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

		return Solution1(sum);
	}

	private static ArrayList<ArrayList<Integer>> Solution1(int sum) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subList = new ArrayList<Integer>();

		if (sum < 3) {
			return list;
		}
		int small = 1;
		int big = 2;
		int middle = (sum + 1) >> 1;
		int curSum = small + big;

		while (small < middle) {
			if (curSum == sum) {
				subList = add(small, big);
				list.add(subList);
			}
			while (curSum > sum && small < middle) {
				curSum -= sum;
				small++;
				if (curSum == sum) {
					subList = add(small, big);
					list.add(subList);
				}

			}
			big++;
			curSum += big;
		}

		return list;
	}

	private static ArrayList<Integer> add(int start, int end) {
		ArrayList<Integer> subList = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			subList.add(i);
		}
		return subList;
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}
}