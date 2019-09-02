package com.hao.offer;

/**
 * 【面试题63】 【股票的最大利润】
 *  假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少?
 *  例如，一只股票在某些时间节点的价格为{9, 11,8,5,7,12,16,14}。
 *  如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
 * 
 * @author hao
 *
 */
public class Offer063 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int MaxDiff(int[] numbers) {
		return Solution1(numbers);
	}


	private static int Solution1(int[] numbers) {
		
		if(numbers==null || numbers.length<2) {
			return 0;
		}
		
		int min = numbers[0];
		int maxDiff = numbers[1] - min;
		
		for(int i=2;i<numbers.length;i++) {
			if(numbers[i-1]<min) {
				min = numbers[i-1];
			}
			int currDiff = numbers[i]-min;
			if(currDiff>maxDiff) {
				maxDiff = currDiff;
			}
		}
		
		return maxDiff;
	}

	private static void test1() {
		int[] numbers= {9, 11,8,5,7,12,16,14};
		System.out.println(MaxDiff(numbers));
	}

	private static void test2() {

	}
	private static void test3() {

	}

}