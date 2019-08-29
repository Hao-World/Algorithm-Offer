package com.hao.offer;

import java.util.Arrays;

/**
 * 【面试题61】 【扑克牌中的顺子】 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。 2~10 为数字本身，A为1, J为11,
 * Q为12，K为13，而大、小王可以看成任意数字。
 * 
 * @author hao
 *
 */
public class Offer061 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static boolean isContinuous(int[] numbers) {
		return Solution1(numbers);
	}

	private static boolean Solution1(int[] numbers) {
		if (numbers == null || numbers.length <= 0)
			return false;
		Arrays.sort(numbers);
		int numberOf0 = 0;
		int numberOfGap = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0)
				numberOf0++;
		}
		int small = numberOf0;
		int big = numberOf0 + 1;
		while (big < numbers.length) {
			if (numbers[small] == numbers[big])
				return false;
			numberOfGap += numbers[big++] - numbers[small++] - 1;
		}
		if (numberOf0 >= numberOfGap) 
			return true;
		return false;
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}

}