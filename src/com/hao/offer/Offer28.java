package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题28】 【对称的二叉树】 
 * 请实现一个函数，用来判断一-棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 
 * @author hao
 *
 */
public class Offer28 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static boolean isSymmertrical(TreeNode pRoot) {
		return Solution1(pRoot);
	}

	private static boolean Solution1(TreeNode pRoot) {
		return isSymmertrical(pRoot, pRoot);
	}

	private static boolean isSymmertrical(TreeNode pRoot1, TreeNode pRoot2) {
		if (pRoot1 == null && pRoot2 == null) {
			return true;
		}
		if (pRoot1 == null || pRoot2 == null) {
			return false;
		}
		if (pRoot1.val != pRoot2.val) {
			return false;
		}
		return isSymmertrical(pRoot1.left, pRoot2.right) 
				&& isSymmertrical(pRoot1.right, pRoot2.left);
	}

	private static void test1() {
	}

	private static void test2() {
	}

	private static void test3() {
	}
}