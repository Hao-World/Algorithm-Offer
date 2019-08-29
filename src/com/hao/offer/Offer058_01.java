package com.hao.offer;

/**
 * 【面试题58-1】 【翻转单词顺序】
 *  输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *  为简单起见，标点符号和普通字母样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 
 * @author hao
 *
 */
public class Offer058_01 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	 public static String ReverseSentence(String str) {
		return Solution1(str);
	}


	private static String Solution1(String str) {
		if(str==null || str.length() <= 0) {
			return str;
		}
		char[] chars = str.toCharArray();
		
		reverseCore(chars, 0, chars.length-1);
		
		int start = 0;
		int end =0;	
		
		while(start<chars.length){
            while(end<chars.length && chars[end]!=' ')
                end++;
            reverseCore(chars,start,end-1);
            start=++end;
        }
		
		return String.valueOf(chars);
	}
	
	private static void reverseCore(char[] chars ,int start,int end) {
		while(start<end) {
			char tmp = chars[start];
			chars[start]=chars[end];
			chars[end]=tmp;
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