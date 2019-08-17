package com.hao.offer;

/**
 * 【面试题33】 【二叉搜索树的后序遍历序列】
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *  如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author hao
 *
 */
public class Offer33 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static  boolean VerifySquenceOfBST(int [] sequence) {
		return Solution1(sequence);
	}
	private static boolean Solution1(int [] sequence) {
		if(sequence==null || sequence.length<=0) {
			return false;
		}
		return verifyCore(sequence, 0, sequence.length-1);
	}
	public static boolean verifyCore(int[] sequence,int start,int end) {
		if(start>=end) {
			return true;
		}
		int mid =start ;
		while(sequence[mid]<sequence[end]) {
			mid++;
		}
		for(int i=mid;i<end;i++) {
			if(sequence[i]<sequence[end]) {
				return false;
			}
		}
		return verifyCore(sequence, start, mid-1) && verifyCore(sequence, mid, end-1);
	} 

	private static void test1() {
		int[] sequence = {5,7,6,9,11,10,8};
		boolean verifySquenceOfBST = VerifySquenceOfBST(sequence);
		System.out.println(verifySquenceOfBST);
	}

	private static void test2() {

	}
	private static void test3() {

	}

}