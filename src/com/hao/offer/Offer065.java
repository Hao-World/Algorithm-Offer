package com.hao.offer;

/**
 * 【面试题65】 【不用加减乘除做加法】
 *  写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 
 * @author hao
 *
 */
public class Offer065 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	 public static int Add(int num1,int num2) {
		return Solution1(num1,num2);
	}


	private static int Solution1(int num1, int num2) {
		while(num2!=0){
            int sum=num1^num2;  //没进位的和
            int carry=(num1&num2)<<1;  //进位
            num1=sum;
            num2=carry;
        }
        return num1;
	}

	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}