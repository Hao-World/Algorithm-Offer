package com.hao.offer;

/**
 * 【面试题14】
 * 【剪绳子】
 * 给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘积是多少？
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 * @author hao
 *
 */
public class Offer014 {
	public static void main(String[] args) {
		System.out.println("功能测试--->");
		test1();
		System.out.println("边界值测试--->");
		test2();
	}
	
	public static int maxProductAfterCutting(int n) {
		return Solution2(n);
	}

	/**
	 * 解法一：动态规划
	 * 思路： 定义函数f(n) 为将长度为n的绳子剪成若干段后各段长度乘积的最大值
	 * 1.  f(0) = 0
	 * 2.  f(1) = 0  因为此处绳子的长度大于乘积的值， 所以实际操作的时候 使用绳子的长度
	 * 3.  f(2) = 1  同上
	 * 4.  f(3) = 2  同上
	 * 5.  f(n) = max(f(i)*f(n-i)), 1< i <n
	 * 
	 * @param n
	 * @return
	 */
	private static int Solution1(int length) {
		
		if(length<=1) {
			return 0;
		}
		if(length == 2 ) {
			return 1;
		}
		if(length == 3) {
			return 2;
		}
		int[] product = new int[length+1];
		product[0] = 0;
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;
		
		for(int i=4 ;i<=length;i++) {
			int max = 0;
			for(int j=1;j<=i/2;j++) {
				if(max < product[j]*product[i-j]) {
					max = product[j] * product[i-j];
				}
			}
			product[i] = max;
		}
		
		return product[length];
	}
	
	/**
	 * 解法二： 贪心算法
	 * 思路: 尽可能多的减成长度为3的绳子段
	 */
	private static int Solution2(int length) {
		if(length<=1) {
			return 0;
		}
		if(length==2) {
			return 1;
		}
		if(length==3 ) {
			return 2;
		}
		
		int timeOf3 = length/3;
		if(length - timeOf3*3 == 1) {
			timeOf3 -= 1;
		}
		int timeOf2 = (length-timeOf3*3) / 2;
		return (int) Math.pow(3, timeOf3) * (int)Math.pow(2,timeOf2);
	}
	
	/**
	 * 测试功能
	 */
	private static void test1() {
		System.out.println("绳子长度为8:"+maxProductAfterCutting(8));
	}
	/**
	 * 测试边界值
	 */
	private static  void test2() {
		System.out.println("绳子长度为0:"+maxProductAfterCutting(0));
		System.out.println("绳子长度为1:"+maxProductAfterCutting(1));
		System.out.println("绳子长度为2:"+maxProductAfterCutting(2));
		System.out.println("绳子长度为3:"+maxProductAfterCutting(3));
		System.out.println("绳子长度为4:"+maxProductAfterCutting(3));
	}
}
