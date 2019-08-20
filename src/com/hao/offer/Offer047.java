package com.hao.offer;

/**
 * 【面试题47】 【礼物的最大价值】
 *  在一个`m*n`的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值(价值大于0)。
 *  你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格，
 *  直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物?
 * 
 * @author hao
 *
 */
public class Offer047 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int getMaxValue(int[][] values) {
		return Solution2(values);
	}

	/**
	 * 用二位数组缓存
	 * @param values
	 * @return
	 */
	private static int Solution1(int[][] values) {
		if(values==null || values.length<=0 || values[0].length<=0) {
			return 0;
		}
		int rows = values.length;
		int cols = values[0].length;
		int[][] maxValues = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				int left = 0;
				int up = 0;
				if(i>0) {
					up = maxValues[i-1][j];
				}
				if(j>0) {
					left = maxValues[i][j-1];
				}
				maxValues[i][j] = Math.max(up,left)+values[i][j];
			}
		}
		
		return maxValues[rows-1][cols-1];
	}

	/**
	 * 可以简化为一维数组
	 * @param values
	 * @return
	 */
	private static int Solution2(int[][] values) {
		if(values==null || values.length<=0 || values[0].length<=0) {
			return 0;
		}
		int rows = values.length; //行
		int cols = values[0].length;//列
		
		int[] maxValue = new int[cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				int left = 0;
				int up = 0;
				if(i>0) {
					up = maxValue[j];
				}
				if(j>0) {
					left = maxValue[j-1];
				}
				maxValue[j] = Math.max(up,left)+values[i][j];
			}
		}
		return maxValue[cols-1];
	}

	private static void test1() {
		int[][] values = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		int maxValue = getMaxValue(values);
		System.out.println(maxValue);
	}

	private static void test2() {

	}
	private static void test3() {

	}

}