package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题55-2】 【平衡二叉树】
 *  输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 
 * @author hao
 *
 */
public class Offer055_02 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static  boolean IsBalanced_Solution(TreeNode root) {
		return Solution1(root);
	}

	private static boolean Solution1(TreeNode root) {
		return getDepth(root)!=-1;
	}
	
	private static int  getDepth(TreeNode root) {
		if(root==null) return 0;
		int leftDep = getDepth(root.left);
		if(leftDep == -1) return -1;
		int rightDep = getDepth(root.right);
		if(rightDep==-1) return -1;
		return Math.abs(leftDep-rightDep) >1 ? -1 :(Math.max(leftDep,rightDep) + 1);
	}

	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}