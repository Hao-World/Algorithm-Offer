package com.hao.offer;

import java.util.ArrayList;

/**
 * 【面试题29】 【顺时针打印矩阵】 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 
 * @author hao
 *
 */
public class Offer29 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		return Solution1(matrix);
	}

	private static ArrayList<Integer> Solution1(int[][] matrix) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
			return null;
		}
		int start = 0;
		int rows = matrix.length;
		int columns = matrix[0].length;

		ArrayList<Integer> listSum = new ArrayList<Integer>();

		while (columns > start * 2 && rows > start * 2) {
			ArrayList<Integer> list = printMatrix(matrix, rows, columns, start);
			listSum.addAll(list);
			++start;
		}

		return listSum;
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix, int rows, int columns, int start) {
		int endX = columns - 1 - start;// 横坐标
		int endY = rows - 1 - start;// 竖坐标
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 左到右打印
		for (int i = start; i <= endX; i++) {
			int num = matrix[start][i];
			System.out.println(num + ",");
			list.add(num);
		}

		// 从上到下打印
		if (start < endY) {
			for (int j = start + 1; j <= endY; j++) {
				int num = matrix[j][endX];
				System.out.println(num + ",");
				list.add(num);
			}
		}

		// 从右到左打印
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				int num = matrix[endY][i];
				System.out.println(num);
				list.add(num);
			}
		}
		// 从下往上打印
		if (start < endX && start + 1 < endY) {
			for (int j = endY - 1; j >= start + 1; j--) {
				int num = matrix[j][start];
				System.out.print(num + ",");
				list.add(num);
			}
		}

		return list;

	}

	private static void test1() {}
	private static void test2() {}
	private static void test3() {}

}