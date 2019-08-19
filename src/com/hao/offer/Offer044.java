package com.hao.offer;

/**
 * 【面试题44】 【数字序列中某一位的数字】
 *  数字以0123456789101112131415..的格式序列化到一个字符序列中。
 *  在这个序列中，第5位(从0开始计数)是5,第13位是1，第19位是4，等等。
 *  请写一个函数，求任意第n位对应的数字。
 * 
 * @author hao
 *
 */
public class Offer044 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int  digitAtIndex(int index) {
		return Solution1(index);
	}

	private static int Solution1(int index) {
		if(index<0) {
			return -1;
		}
		int m=1; // m位数
		while(true) {
			int numbers = countOfIntegers(m);//得到m位数的个数
			if(index<numbers*m) {//如果 序列号小于 m位数所占的位数
				return getDigit(index,m);
			}
			index -= m*numbers;
			m++;
		}	
	}

	/**
	 * 得到m位数的个数 
	 * m=1时 0~9 10个
	 * m=2时 10~99 9*10
	 * m=3时 100~999 9*(10^2)
	 * @param m
	 * @return
	 */
	private static int countOfIntegers(int m) {
		if(m==1) {
			return 10;
		}
		return (int) (9*Math.pow(10, m-1));
	}
	/**
	 * 获取数字
	 * @param index
	 * @param m
	 * @return
	 */
	private static int getDigit(int index, int m) {
		int number = getFirstNumber(m)+index/m; //对应的m位数
		int indexFromRight = m-index%m; //在数字中的位置
		for(int i=1;i<indexFromRight;i++)
            number/=10;
		return number%10;
	}

	
	/**
	 * m位数的首个数字
	 * m=1, 0
	 * m=2, 10
	 * m=3, 10^2
	 * 
	 * @param m
	 * @return
	 */
	private static int getFirstNumber(int m) {
		if(m==1)
			return 0;
		return (int) Math.pow(10,m-1);
	}

	private static void test1() {
		System.out.println(digitAtIndex(1000));
	}

	private static void test2() {
		System.out.println(digitAtIndex(0));
	}
	private static void test3() {
		System.out.println(digitAtIndex(1));
	}
}