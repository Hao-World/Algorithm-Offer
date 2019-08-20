package com.hao.offer;

/**
 * 【面试题46】 【把数字翻译成字符串】
 *  给定一个数字，我们按照如下规则把它翻译为字符串:
 *   0翻译成“a”，1翻译成“b”，..... 11翻译成“1”，...... 25翻译成“z”。
 *   一个数字可能有多个翻译。例如，12258有5种不同的翻译，
 *   分别是“bccfi”“bwfi”、“bczi”、“mcfi”和“mzi”。 
 *  请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 
 * @author hao
 *
 */
public class Offer046 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	 public static int GetTranslationCount(int number) {
		return Solution1(number);
	}


	private static int Solution1(int number) {
		if(number<0) {
			return 0;
		}
		String strNum = String.valueOf(number);
		int length = strNum.length();
		int[] count = new int[length];
		for(int i=length-1;i>=0;i--) {
			if(i==length-1) {
				count[i] = 1;
			}else {
				count[i] = count[i+1];
				int a=strNum.charAt(i)-'0';
		        int b=strNum.charAt(i+1)-'0';
		        int convertNum = a*10+b;
		        if(convertNum>=10 && convertNum<=25) {
		        	if(i==length-2) {
		        		count[i]+=1;
		        	}else {
		        		count[i]+=count[i+2];
		        	}
		        }
			}
		}
		return count[0];
	}

	private static void test1() {
		int count = GetTranslationCount(12258);
		System.out.println(count);
	}

	private static void test2() {
		System.out.println(GetTranslationCount(0));
	}
	private static void test3() {
		System.out.println(GetTranslationCount(2526));
	}

}