package com.hao.offer;

/**
 * 【面试题58-2】 【左旋转字符串】 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2, 该函数将返回左旋转两位得到的结果"cdefgab"。
 * 
 * @author hao
 *
 */
public class Offer058_02 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static String LeftRotateString(String str, int n) {
		return Solution1(str, n);
	}

	private static String Solution1(String str, int n) {
		
		if(str==null|| str.length()<=0) {
			return str;
		}
		if(n<=0 || n> str.length()) {
			return str;
		}
		char[] charArray = str.toCharArray();
		
		reverseCore(charArray, 0, n-1);
		reverseCore(charArray, n, charArray.length-1);
		reverseCore(charArray, 0, charArray.length-1);
		return String.valueOf(charArray);
	}
	
	private static void reverseCore(char[] s,int start,int end) {
		while(start<end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}

}