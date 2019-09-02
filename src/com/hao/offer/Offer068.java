package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题68】 【树中两个结点的最低公共祖先】
 *  输入两个树结点，求它们的最低公共祖先。
 * 
 * @author hao
 *
 */
public class Offer068 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	/*
	 * 二叉搜索树
	 * 利用大小关系即可
	 */
	public TreeNode getLowestCommonParentBST(TreeNode root,TreeNode node1,TreeNode node2) {
	    while(true) {
	        if(root==null)
	            return root;
	        if(root.val<node1.val && root.val<node2.val)
	            root=root.right;
	        else if(root.val>node1.val && root.val>node2.val)
	            root=root.left;
	        else
	            return root;
	    }
	}
	 
	 
	/*
	 * 普通二叉树
	 * 将下面结点的信息利用递归s往上传递
	 */
	public TreeNode getLowestCommonParent(TreeNode root,TreeNode node1,TreeNode node2) {
	    if(root==null || root== node1 || root== node2)
	        return root;
	    TreeNode left=getLowestCommonParent(root.left, node1, node2);
	    TreeNode right=getLowestCommonParent(root.right, node1, node2);
	    return left==null? right:right==null? left:root;
	//  上面这句代码就是：
	//  if(left==null) {
//	          return right;
	//  }else {
//	      if(right==null)
//	          return left;
//	      else
//	          return root;
	//  }
	}


	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}