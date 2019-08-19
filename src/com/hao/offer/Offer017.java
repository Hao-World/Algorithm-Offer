package com.hao.offer;

import java.util.Arrays;

/**
 * 【面试题17】 【打印1到最大的n位数】 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入4，则打印出1、2、3、4一直到最大的4位数即9999。
 * 
 * @author hao
 *
 */
public class Offer017 {

	public static void main(String[] args) {
		System.out.println("功能测试--->");
		test1();
		System.out.println("特殊值测试--->");
		test2();
	}

	public static void print1ToMaxOfNDigits(int n) {
		Solution1(n);
	}

	/**
	 * 用模拟加1 的方法
	 * 
	 * @param n
	 */
	private static void Solution1(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("参数非法");
		}
		char[] number = new char[n];
		Arrays.fill(number, '0');// 全部初始化为为'0'
		while (!increment(number)) {
			printCharNumber(number);
		}
	}

	/**
	 * 对字符串进行加一操作,注意停止加一的时机，即当最高位+1时，如果产生进位，则停止加1 ，比如：999+1
	 * 
	 * @param number
	 * @return
	 */
	private static boolean increment(char[] number) {
		boolean isOverflow = false; // 判断最高位是否产生进位，停止+1的条件
		int nTakeOver = 0; // 产生的进位
		// 数组从后往前遍历，数组后面的位表示数值的低位
		for (int i = number.length - 1; i >= 0; i--) {
			int nSum = (number[i] - '0') + nTakeOver;
			if (i == number.length - 1) {
				nSum++;
			}
			if (nSum >= 10) {
				if (i == 0) {// 最高位
					isOverflow = true;
				} else {
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			} else {
				number[i] = (char) ('0' + nSum);
				break;
			}
		}
		return isOverflow;
	}

	/**
	 * 打印字符数组形成的数字，注意当遇到不是'0'的时候才开始打印
	 */
	private static void printCharNumber(char[] number) {
		boolean isBeginning0 = true;
		for (int i = 0; i < number.length; i++) {
			if (isBeginning0 && (number[i] - '0') != 0) {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}

	private static void test1() {
		System.out.println("2---->");
		print1ToMaxOfNDigits(2);
	}

	private static void test2() {
		System.out.println("-1---->");
		print1ToMaxOfNDigits(-1);
		System.out.println("0---->");
		print1ToMaxOfNDigits(0);
	}

}
