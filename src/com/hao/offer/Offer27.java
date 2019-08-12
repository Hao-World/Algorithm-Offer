package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题27】 【二叉树的镜像】
 * 请完成一个函数，输入一颗二叉树，该函数输出它的镜像。
 *  模版
 * 
 * @author hao
 *
 */
public class Offer27 {
	public static void main(String[] args) {
		System.out.println("测试太麻烦了以后再弄吧");
		System.out.println("效率太低，还是通过牛客网测试吧");
		test1();
		test2();
		test3();
		
	}

	public void Mirror(TreeNode root) {
        Solution1(root);
    }

	private static void Solution1(TreeNode root) {
		if(root==null) return ;
		if(root.left==null && root.right==null) {
			return ;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if(root.left!=null) {
			Solution1(root.left);
		}
		if(root.right!=null) {
			Solution1(root.right);
		}
	}
	private static void test1() {
	}

	private static void test2() {
	}
	private static void test3() {
	}
}