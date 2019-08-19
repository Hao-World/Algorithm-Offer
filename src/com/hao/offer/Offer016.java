package com.hao.offer;

/**
 * 【面试题16】 【】 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 
 * @author hao
 *
 */
public class Offer016 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static double powCustom(double base, int exponent) {
		return Solution2(base, exponent);
	}

	/**
	 * 解法一， 要考虑到边界值， exponent为负数时，还要比如0的负数次方
	 * 
	 * 其中powCustomCore1 方法是利用 直接求的方法
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	private static double Solution1(double base, int exponent) {
		if (base == 0 && exponent < 0) {
			throw new IllegalArgumentException("0的指数不能为负数");
		}
		int absExponent = exponent;
		if (exponent < 0) {
			absExponent = -exponent;
		}
		double result = powCustomCore1(base, absExponent);
		if (exponent < 0) {
			result = 1.0 / result;
		}
		return result;
	}

	/**
	 * 方法一： 直接求，将exponent个 base 相乘
	 * 
	 * @param base     基数
	 * @param exponent 指数
	 * @return
	 */
	private static double powCustomCore1(double base, int exponent) {
		double result = 1.0;
		for (int i = 1; i <= exponent; i++) {
			result *= base;
		}
		return result;
	}

	/**
	 * 解法二， 要考虑到边界值， exponent为负数时，还要比如0的负数次方
	 * 
	 * 其中 powCustomCore2 方法是利用 递归的方法
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	private static double Solution2(double base, int exponent) {
		if (base == 0 && exponent < 0) {
			throw new IllegalArgumentException("0的指数不能为负数！");
		}
		int absExponent = exponent;
		if (exponent < 0) {
			absExponent = -exponent;
		}
		double result = powCustomCore2(base, absExponent);
		if (exponent < 0) {
			result = 1.0 / result;
		}
		return result;
	}

	/**
	 * 方法二：
	 * 
	 * exponent为偶数时，可以将其简化为 两个base的 ex/2 次幂 相乘 exponent为奇数时，可以将其简化为，两个base的 ex/2 次幂
	 * 相乘之后再乘以base
	 * 
	 * @param base     基数
	 * @param exponent 指数
	 * @return
	 */
	private static double powCustomCore2(double base, int exponent) {
		if (exponent == 0) {
			return 0;
		}
		if (exponent == 1) {
			return base;
		}
		double result = powCustomCore2(base, exponent >> 1);
		result *= result;
		if ((exponent & 1) == 1) {
			result *= base;
		}
		return result;
	}

	private static void test1() {
		System.out.println("3,3---->" + powCustom(3, 3));
	}

	private static void test2() {
		System.out.println("3,-3----->" + powCustom(3, -3));
	}

	private static void test3() {
		System.out.println("-3,3------>" + powCustom(-3, 3));
	}
}
