package com.hao.offer;

import java.util.HashMap;

/**
 * 【面试题50-1】 【第一个只出现一次的字符】 
 * 
 *  在字符串中找出第一个只出现一次的字符。如输入"abaccdeff",则输出'b'。
 * 
 * @author hao
 *
 */
public class Offer050_01 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static int FirstNotRepeatingChar(String str) {
		return Solution1(str);
	}

	private static int Solution1(String str) {
		if (str.length() == 0 || str == null) {
			return -1;
		}
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c) + 1);
			} else {
				hashMap.put(c, 1);
			}
		}
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (hashMap.get(c) == 1) {
				return i;
			}
		}
		return 0;
	}
	
	
	public int Solution2(String str) {
		if (str == null || str.length() == 0)
			return -1;
		int[] repetitions = new int[256];
		for (int i = 0; i < 256; i++)
			repetitions[i] = 0;
		for (int i = 0; i < str.length(); i++) {
			int loc = (int) str.charAt(i);
			repetitions[loc] += 1;
		}
		for (int i = 0; i < str.length(); i++) {
			int loc = (int) str.charAt(i);
			if (repetitions[loc] == 1)
				return i;
		}
		return -1;
	}
	

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}
}