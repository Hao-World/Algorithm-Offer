package com.hao.common;

import java.util.Stack;

/**
 * 待完善
 * 二叉树结构
 * @author hao
 *
 */
public class TreeNode {
	public int val;
	public TreeNode left=null;
	public TreeNode right=null;
	public TreeNode(int val) {
		this.val = val;
	}
	
	
	
	
	
	
	/**
	 * 前序遍历 递归
	 * @param tree
	 */
	public  static void preOrder(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		System.out.print(tree.val+" ");
		preOrder(tree.left);
		preOrder(tree.right);
	}
	/**
	 * 前序遍历非递归
	 * @param tree
	 */
	public static void preOrderNonReCurSive(TreeNode tree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = tree;
		while(p!=null || !stack.isEmpty()) {
			if(p!=null) {
				System.out.print(p.val);
				stack.push(p);
				p=p.left;
			}else {
				TreeNode pop = stack.pop();
				p = pop.right;
			}
		}
	}
	
	/**
	 * 中序遍历 递归
	 * @param tree
	 */
	public static void inOrder(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		inOrder(tree.left);
		System.out.print(tree.val);
		inOrder(tree.right);
	}
	/**
	 * 中序遍历非递归
	 * @param tree
	 */
	public static void inOrderNonRecursive(TreeNode tree) {
		Stack<TreeNode> stack = new Stack<TreeNode>(); 
		TreeNode p = tree;
		while(p!=null || !stack.isEmpty()) {
			if(p!=null) {
				stack.push(p);
				p=p.left;
			}else {
				TreeNode pop = stack.pop();
				System.out.print(pop.val);
				p = pop.right;
			}
			
		}
	}
	
	/**
	 * 后序遍历 递归
	 * @param tree
	 */
	public static void postOrder(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		postOrder(tree.left);
		postOrder(tree.right);
		System.out.print(tree.val);
	}
	/**
	 * 后序遍历非递归
	 * @param tree
	 */
	public static void postOrderNonReCurSive(TreeNode tree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = tree,r =null;
		while(p!=null || !stack.isEmpty()) {
			if(p!=null) {
				stack.push(p);
				p=p.left;
			}else {
				TreeNode peek = stack.peek();//取栈顶元素
				if(peek.right!=null&&peek.right!=r) {//栈顶元素如果有右子树，且没有被访问过
					p = peek.right;			//转向右
					stack.push(p);   //将右子树压入栈中
					p=p.left;		//再走到最左
				}else {
					TreeNode pop = stack.pop();  //否则弹出栈访问
					System.out.print(pop.val); 
					r = pop;   //标记为被访问
//					p = null; //重置p指针为空 ，这不可以不要
				}
			}
		}
	}
	
	
}
