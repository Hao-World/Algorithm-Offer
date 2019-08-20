package com.hao.offer;

/**
 * 【面试题49】 【丑数】
 *  我们把只包含因子2、3和5的数称作丑数( Ugly Number)。
 *  求按从小到大的顺序的第1500个丑数。
 *  例如，6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当作第一个丑数。
 * 
 * @author hao
 *
 */
public class Offer049 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int GetUglyNumber(int index) {
		return Solution2(index);
	}


	/**
	 * 挨个判断是否是丑数，直到找到index个丑数为止
	 * 时间效率低下
	 * @param index
	 * @return
	 */
	private static int Solution1(int index) {
		if(index<=0) {
			return 0;
		}
		int number = 0;
		int uglyCount = 0;
		while(uglyCount<index) {
			++number;
			if(isUglyNumber(number)) {
				++uglyCount;
			}
		}
		return number;
	}
	
	private static int Solution2(int index) {
		if(index<=0) {
			return 0;
		}
		int[] uglyNumbers = new int[index];
		uglyNumbers[0]=1;
		int index2=0;
		int index3=0;
		int index5=0;
		for(int i=1;i<index;i++) {
			uglyNumbers[i] = getMin(uglyNumbers[index2]*2 ,uglyNumbers[index3]*3,uglyNumbers[index5]*5);
			while(uglyNumbers[index2]*2<=uglyNumbers[i]) {
				index2++;
			}
			while(uglyNumbers[index3]*3<=uglyNumbers[i]) {
				index3++;
			}
			while(uglyNumbers[index5]*5<=uglyNumbers[i]) {
				index5++;
			}
		}
		
		return uglyNumbers[index-1];
	}
	
	
	private static int getMin(int i, int j, int k) {
		int min = (i<j) ? i:j;
		min = (min<k)? min:k;
		return min;
	}

	private static boolean isUglyNumber(int number) {
		while(number%2==0) {
			number/=2;
		}
		while(number%3==0) {
			number/=3;
		}
		while(number%5==0) {
			number/=5;
		}
		return number==1;
	}
	
	private static void test1() {
		System.out.println(GetUglyNumber(6));
		System.out.println(GetUglyNumber(1500));
	}

	private static void test2() {
		System.out.println(GetUglyNumber(0));
	}
	private static void test3() {

	}

}