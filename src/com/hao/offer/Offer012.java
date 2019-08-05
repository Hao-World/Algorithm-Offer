package com.hao.offer;

/**
 * 
 * 【面试题12】 【矩阵中的路径】 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 
 * @author hao
 *
 */
public class Offer012 {
	public static void main(String[] args) {
		char[] matrix = "ABTGCFCSJDEH".toCharArray();
		int rows = 3;
        int cols = 4;
        char[] str = "ATCE".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println(" existed.");
        else
            System.out.println(" no existed.");
	}

	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		return Solution1(matrix, rows, cols, str);
	}

	/**
	 * 
	 * @param matrix 矩阵
	 * @param rows   行数
	 * @param cols   列数
	 * @param str    给出的路径
	 * @return
	 */
	public static boolean Solution1(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		boolean[] isVisited = new boolean[rows * cols];
		for (boolean b : isVisited) {
			b = false;
		}
		int pathLength = 0; // 代表自己搜寻的路径 所组成字符串 的下标
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param matrix     矩阵
	 * @param rows       行数
	 * @param cols       列数
	 * @param row        当前格子的行
	 * @param col        当前格子的列
	 * @param str        给出的路径
	 * @param pathLength 路径的下标
	 * @param isVisited  访问标记数组
	 * @return
	 */
	private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
			boolean[] isVisited) {
		if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row * cols + col] == true
				|| str[pathLength] != matrix[row * cols + col]) {
			// 如果搜寻的格子被访问过 ，如果搜寻的格子 不符合给出的路径
			return false;
		}
		if (pathLength == str.length - 1) {
			return true;
		}
		boolean hasPath = false;
		isVisited[row * cols + col] = true;// 第一个元素设置为已经访问
		// 搜寻下一个元素(上--下--左--右)
		hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited);

		if (!hasPath) { // 回溯标记为false
			isVisited[row * cols + col] = false;
		}
		return hasPath;
	}

}
