package com.hao.offer;

/**
 * 【面试题13】
 * 【机器人的运动范围】
 *  地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 *  每一次只能向左，右，上，下四个方向移动一格，
 *  但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *  但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author hao
 *
 */
public class Offer13 {

	public static void main(String[] args) {
		System.out.println(movingCount(18, 3, 4));
	}
	
	public static int movingCount(int threshold, int rows, int cols)
    {
        return Solution1(threshold, rows, cols);
    }
	
	/**
	 * 
	 * 思路：设置一个访问标记数组，机器人进入格子的条件要同时满足
	 * 1.这个格子没有被标记
	 * 2.这个格子的下标位数之和 <= threshold
	 * 继续判断其上下左右的格子是否可以进入
	 * @param threshold
	 * @param rows
	 * @param cols
	 * @return
	 */
	private  static int Solution1(int threshold, int rows, int cols)
    {
		if(threshold < 0 || rows < 0 || cols < 0) {
			return 0;
		}
		boolean[] visited = new boolean[rows*cols];
		for(boolean b: visited) {
			b = false;
		}
		int count = movingCountCore(threshold,rows,cols,0,0,visited);
		
        return count;
    }
	private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		
		if(row < 0 || row >= rows || col <0 || col>=cols 
				|| getDigitSum(row)+getDigitSum(col) > threshold 
				|| visited[row*cols+col]) { // 判断是否可以进入此格子
			return 0;
		}
		
		int count = 0;
		visited[row*cols+col] = true;
		count = 1 + movingCountCore(threshold, rows, cols, row, col-1, visited)
				+ movingCountCore(threshold, rows, cols, row, col+1, visited)
				+ movingCountCore(threshold, rows, cols, row-1, col, visited)
				+ movingCountCore(threshold, rows, cols, row+1, col, visited);
		
		return count;
	}
	
//	/**
//	 * 此函数用于判断机器人是否可以进入某一个格子
//	 * @param threshold  格子位数之和要 <= 该值
//	 * @param rows 行数
//	 * @param cols 列数
//	 * @param row 
//	 * @param col
//	 * @param visited  访问标记数组
//	 * @return
//	 */
//	private static boolean check(int threshold,int rows,int cols,int row,int col,boolean[] visited) {
//		if(row < 0 || row >= rows || col <0 || col>=cols 
//				|| getDigitSum(row)+getDigitSum(col) > threshold 
//				|| visited[row*cols+col]) {
//			return false;
//		}
//		return true;
//	}
	private static int getDigitSum(int number) {
		int sum = 0;
		while(number > 0) {
			sum += number%10;
			number /= 10;
		}
		return sum;
	}
}
