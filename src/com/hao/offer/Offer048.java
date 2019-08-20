package com.hao.offer;

/**
 * 【面试题48】 【最长不含重复字符的子字符串】
 *  请从字符串中找出一个最长的不包含重复字符的子字符串，
 *  计算该最长子字符串的长度。假设字符串中只包含'a'~'z'的字符。
 *  例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr",长度为4。
 * 
 * @author hao
 *
 */
public class Offer048 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int LongSubStringWithOutDup(String str) {
		return Solution1(str);
	}
	private static int Solution1(String str) {
		if(str==null || str.length()<=0) {
			return 0;
		}
		int preLength = 0;
		int curLength = 0;
		int maxLength = 0;
		int[] position = new int[26];
		for(int i=0;i<position.length;i++) {
			position[i]=-1;
		}
		for(int i=0;i<str.length();i++) {
			int prevIndex = position[str.charAt(i)-'a'];
			if( prevIndex <0 || i-prevIndex > preLength) {
				// 第i个字符之前没有出现过或者出现过但是距离大于f(i-1)
				curLength = preLength+1;
			}else {
				curLength = i-prevIndex;
			}
			position[str.charAt(i)-'a'] = i;
			if(curLength>maxLength) {
				maxLength=curLength;
			}
			preLength = curLength;
		}
		
		return maxLength;
	}

	private static void test1() {
		int result = LongSubStringWithOutDup("arabcacfr");
		System.out.println(result);
	}

	private static void test2() {

	}
	private static void test3() {

	}

}