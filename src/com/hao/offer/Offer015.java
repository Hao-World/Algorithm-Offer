package com.hao.offer;

/**
 * 【面试题15】 【二进制中1的个数】 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * @author hao
 *
 */
public class Offer015 {
	public static void main(String[] args) {
		System.out.println("测试正数-->");
		test1();
		System.out.println("测试负数-->");
		test2();
		System.out.println("测试0-->");
		test3();
	}
	public static int NumberOf1(int n) {
		return Solution3(n);
	}
	/**
	 * 可以说这种解法是错误的❌ 此种解法会出现死循环，因为如果输入为负数 右移是在高位补的是1， 如果一直做右移运算那么数字会变成0xFFFFFFFF变成死循环
	 * 错误的 思路 ：判断整数的二进制表示中最右边的一位是不是1(判断方法为将整数和1相与)， 右移一位后继续判断， 就可以统计出
	 * 整数中的二进制表示中1的个数
	 * 
	 * @param n
	 * @return
	 */
	private static int Solution1(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) != 0) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	/**
	 * 解法一： 思路： 上面的思路是移动 整数，我们可以移动与整数相与的1 ，每次判断之后我们将1 向左移动， 这时判断的就是整数所表示二进制中右边的第二位
	 * 
	 * @param n
	 * @return
	 */
	private static int Solution2(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((flag & n) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	/**
	 * 解法二： 思路 ：利用了一种二进制运算的规律，把一个整数减去1之后再和原来的整数做与运算， 得到的结果相当于把整数二进制中最右边的1变为0
	 * 
	 * @param n
	 * @return
	 */
	private static int Solution3(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	/**
	 * 测试正数
	 */
	private static void test1() {
		System.out.println("0x7FFFFFFF: " + NumberOf1(0x7FFFFFFF));
		System.out.println("1: " + NumberOf1(1));
	}

	/**
	 * 测试负数
	 */
	private static void test2() {
		System.out.println("0x80000000： " + NumberOf1(0x80000000));
		System.out.println("0xFFFFFFFF： " + NumberOf1(0xFFFFFFFF));
	}

	/**
	 * 测试0
	 */
	private static void test3() {
		System.out.println("0: " + NumberOf1(0));
	}
}
