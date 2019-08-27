package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题55-1】 【二叉树的深度】
 *  输入一棵二叉树，求该树的深度。
 *  从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * @author hao
 *
 */
public class Offer055_01 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int TreeDepth(TreeNode root) {
		return Solution1(root);
	}


	private static int Solution1(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftDep = Solution1(root.left);
		int rightDep = Solution1(root.right);
		
		return (leftDep>rightDep)? (leftDep+1):(rightDep+1);
	}

	private static void test1() {
	}

	private static void test2() {

	}
	private static void test3() {

	}

}