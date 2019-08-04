package com.hao.offer;

/**
 * 【面试题10】
 * 【斐波那契数列】
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @author hao
 *
 */
public class Offer010_1 {
	public static void main(String[] args) {
		System.out.println(Fibonacci(8));
	}
    public static int Fibonacci(int n) {
    	return Solution2(n);
    }
    /**
     * 递归的思路
     * @param n
     * @return
     */
	private static int Solution1(int n) {
		if(n<=0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		
		return Solution1(n-1)+Solution1(n-2);
	}
	
	/**
	 * 把计算过的只保存起来，保存前面的两项，计算的过程中给前面两项重新赋值
	 * @param n
	 * @return
	 */
	private static int Solution2(int n) {
		int[] arr = {0,1};
		if(n<2) {
			return arr[n];
		}
		int fm1 = 1;// 当前数 前面的第1个数
		int fm2 = 0;//当前数的前面的第2个数
		int fN =0;
		for(int i=2;i<=n;++i) {
			fN = fm1+fm2;
			fm2 = fm1;
			fm1 = fN;
		}
		return fN;
	}
}
