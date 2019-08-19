package com.hao.offer;

/**
 * 【面试题43】 【1~n整数中1出现的次数】
 *  输入一个整数n,求1~n这n个整数的十进制表示中1出现的次数。
 *  例如，输入12, 1~12这些整数中包含1的数字有1、10、11和12,1一共出现了5次。
 * 
 * @author hao
 *
 */
public class Offer043 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int NumberOf1Between1AndN_Solution(int n) {
	    return Solution1(n);
    }


	private static int Solution1(int n) {
		
		int count=0;
		for(int i=1;i<=n;i*=10) {
			int high = n/(i*10);
			int low = n%i;
			int cur = (n/i)%10;
			if(cur == 0) {
				count+=high*i;
			}else if(cur==1) {
				count+=high*i+(low+1);
			}else {
				count+=(high+1)*i;
			}
		}
		return count;
	}

	private static void test1() {
		int times = NumberOf1Between1AndN_Solution(12);
		System.out.println(times);
	}

	private static void test2() {
		System.out.println(NumberOf1Between1AndN_Solution(0));
	}
	private static void test3() {
		System.out.println(NumberOf1Between1AndN_Solution(21345));
	}
}