package com.hao.offer;


/**
 *  【面试题4】
 * 【二维数组中的查找】
 *  在一个二维数组中，
 * 	每一行都按照从左到右递增的顺序排序，
 * 	每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author hao
 *
 */
public class Offer004 {
	public static void main(String[] args) {
//		int [][] arr = {{},{}}; 
		int [][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}; 
//		System.out.println(arr.length);
//		System.out.println(arr[0].length);
		System.out.println(Offer004.findInPartiallySortedMatrix(arr, 11));
		System.out.println(Offer004.findInPartiallySortedMatrix(arr, 7));
	}
	public static boolean findInPartiallySortedMatrix(int[][] arr, int target) {
		return Solution1(arr, target);
	}
	
	/**
	 * 从右上角开始找，如果目标数字小于右上角数字，j--，大于i++,依次缩小查找的范围
	 * 				
	 * @param arr
	 * @param target
	 * @return
	 */
	public static boolean Solution1(int[][] arr, int target) {
		if(arr==null || arr.length<=0 || arr[0].length<=0 ) {
			throw new IllegalArgumentException("参数非法!");
		}	
		int i=0;
		int j= arr[0].length-1;
		while(i<arr.length && j>=0) {
			if(target<arr[i][j]) {
				j--;
			}else if(target>arr[i][j]){
				i++;
			}else {
				return true;
			}
		}	
		return false;
	}
}
