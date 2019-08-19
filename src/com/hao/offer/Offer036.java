package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题36】 【二叉搜索树与双向链表】 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * 。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author hao
 *
 */
public class Offer036 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static TreeNode Convert(TreeNode pRootOfTree) {
		return Solution1(pRootOfTree);
	}

	private static TreeNode Solution1(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return pRootOfTree;
		}
		TreeNode lastNodeInList = null;
		lastNodeInList = covertCore(pRootOfTree, lastNodeInList);
		TreeNode firstNodeInList = lastNodeInList;
		while (firstNodeInList != null && firstNodeInList.left != null) {
			firstNodeInList = firstNodeInList.left;
		}
		return firstNodeInList;
	}

	private static TreeNode covertCore(TreeNode pRootOfTree, TreeNode lastNodeInList) {
		if (pRootOfTree.left != null) {
			lastNodeInList = covertCore(pRootOfTree.left, lastNodeInList);
		}
		pRootOfTree.left = lastNodeInList;
		if (lastNodeInList != null) {
			lastNodeInList.right = pRootOfTree;
		}

		lastNodeInList = pRootOfTree;
		if (pRootOfTree.right != null) {
			lastNodeInList = covertCore(pRootOfTree.right, lastNodeInList);
		}

		return lastNodeInList;
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}
}