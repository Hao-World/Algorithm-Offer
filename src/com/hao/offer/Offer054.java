package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题54】 【二叉搜索树的第k小节点】
 *  给定一棵二叉搜索树，请找出其中第k小的节点。
 * 
 * @author hao
 *
 */
public class Offer054 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static TreeNode KthNode(TreeNode pRoot, int k) {
		return Solution1(pRoot,k);
	}


	private static TreeNode Solution1(TreeNode pRoot, int k) {
		if(pRoot==null || k==0) {
			return null;
		}
		return KthNodeCore(pRoot,k);
	}

	static int index = 0;
	private static TreeNode KthNodeCore(TreeNode pRoot, int k) {
		TreeNode target = null;
		
		if(pRoot.left!=null) {
			target = KthNodeCore(pRoot.left, k);
		}
		if(target== null) {
			index ++ ;
			if(k==index) {
				target=pRoot;
			}
		
		}
		
		if(target==null && pRoot.right!=null) {
			target = KthNodeCore(pRoot.right, k);
		}
		
		return target;
	}

	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}