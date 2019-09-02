package com.hao.offer;

/**
 * 【面试题64】 【求1+2+...+n】
 *  求1+2+...+n,要求不能使用乘除法、for、 while if else. switch、case等关键字及条件判断语句( A?B:C)。
 * 
 * @author hao
 *
 */
public class Offer064 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int Sum(int n) {
		return Solution1(n);
	}


	private static int Solution1(int n) {
		int sum = n;
		boolean  flag = (n>1) && ((sum+=Solution1(n-1))>0);
//		boolean flag = (n==1) || ((sum+=Solution1(n-1))>0);
		return sum;
	}

	private static void test1() {
		System.out.println(Sum(100));
	}

	private static void test2() {

	}
	private static void test3() {

	}

}