package com.hao.offer;

/**
 * 【面试题20】 【表示数值的字符串】
 * 
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * @author hao
 *
 */
public class Offer20 {
	public static void main(String[] args) {
		System.out.println("****功能测试****");
		test1();
		System.out.println("****特殊值测试****");
		test2();
	}
	public static boolean isNumeric(char[] str) {
		return Solution1(str);
	}
	private static int index = 0;// 用于记录全局索引

	/**
	 * A.B E/e A A为带符号整数 B为无符号整数
	 * 
	 * @param str
	 * @return
	 */
	private static boolean Solution1(char[] str) {
		if (str.length == 0 || str == null) {
			return false;
		}
		boolean numeric = scanInteger(str);// 判断A部分 是否是带符号整数

		if (index < str.length && str[index] == '.') {// 判断B部分
			index++;
			/**
			 * 注意这里用的是或，首先 如果可以走到这个判断里，
			 * 就说明前面A部分中不可能出现+1-9之外的其他字符，例如+2342aa.5进入不到这个判断里
			 * 那么， 小数可以没有整数部分 ，如: .123
			 * 		 小数点后面可以没有数字，如： 123.
			 * 		 当前小数点前后可以都有数字，如：123.422
			 * 
			 */
			numeric = scanUnsignedInteger(str) || numeric; 
		}

		if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			index++;
			/**
			 * 当e/E前面没有数字时，不能表示数字如.el、el
			 * 后面没有数字时，不能表示数字，如 12e、12e+5.4
			 */
			numeric = numeric && scanInteger(str);
		}
		if(numeric && index == str.length) {
			return true;
		}
		return false;
	}

	private static boolean scanUnsignedInteger(char[] str) {
		int start = index;
		while (index < str.length && (str[index] - '0' >= 0 && str[index] - '0' <= 9 )) {
			index++;
		}
		if (index > start) {
			return true;
		}
		return false;
	}
	private static boolean scanInteger(char[] str) {
		if (index < str.length && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		return scanUnsignedInteger(str);
	}
	
	/**
	 * 功能测试
	 */
	private static void test1() {
		boolean numeric = isNumeric("+272.".toCharArray());
		System.out.println("+272.-->"+numeric);
		boolean numeric2 = isNumeric("+272.89E+87".toCharArray());
		System.out.println("+272.89E+87-->"+numeric2);
		boolean numeric3 = isNumeric("+272.89E+87".toCharArray());
		System.out.println("+272.8.9E+87-->"+numeric3);
	}
	
	/**
	 * 特殊值输入测试
	 */
	private static void test2() {
		char[] str = {};
		boolean numeric = isNumeric(str);
		System.out.println("{}"+numeric);
		
	}

}
