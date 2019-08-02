package com.hao.offer;


import java.util.Stack;

import com.hao.common.TreeNode;

/**
 * 
 * 【面试题7】 【创建二叉树】
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 *  =====其中测试代码部分还写了二叉树的遍历方法(递归和非递归)===
 * 
 * 
 * @author hao
 *
 */
public class Offer007 {
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7}; 

        int[] in = { 3,2,4,1,6,5,7 };
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test1:");
        preOrderNonReCurSive(root);
        System.out.print("//");
        inOrderNonRecursive(root);;
        System.out.println();
        postOrder(root);
        System.out.println();
        postOrderNonReCurSive(root);
	}

	public static  TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return Solution1(pre, in);
	}
	
	private static TreeNode Solution1(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
            throw new IllegalArgumentException("数组不符合规范！");
        }
		
		return construct(pre, in, 0, pre.length-1, 0, in.length-1);
	}
	
	/**
	 * 构造二叉树的函数
	 * @param pre  前序遍历数组
	 * @param in   中序遍历数组
	 * @param pStart 前序遍历数组的起始下标
	 * @param pEnd	 前序遍历数组的结束下标
	 * @param iStart 中序遍历数组的起始下标
	 * @param iEnd	 中序遍历数组的结束下标
	 * @return
	 */
	private static TreeNode construct(int[] pre,int[] in,int pStart,int pEnd,int iStart,int iEnd) {
		TreeNode root = new TreeNode(pre[pStart]);// 前序遍历数组的第一个元素为根节点
		if(pStart==pEnd && iStart == iEnd) {// 数组中已有一个元素是直接返回根节点
			if(pre[pStart]!=in[iStart]) {
				throw new IllegalArgumentException("参数不符合规范");
			}
			return root;
		}
		
		int index = iStart;//记录 中序遍历数组 中 根的下标
		while(index<=iEnd && root.val!=in[index]) {
			index++;
		}
		if(index>iEnd) {
			throw new IllegalArgumentException("数组不符合规范");
		}
		
		int leftLength = index - iStart; //计算左子树的长度
		if(leftLength>0) {
			root.left = construct(pre, in, pStart+1, pStart+leftLength, iStart, index-1);
		}
		if(leftLength< iEnd-iStart) {  // 如果左子树的长度 < 总长度 说明有右子树
			root.right = construct(pre, in, pStart+leftLength+1, pEnd, index+1, iEnd);
		}
		return root;
		
	} 
	
	
	/**
	 * 前序遍历 递归
	 * @param tree
	 */
	private static void preOrder(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		System.out.print(tree.val);
		preOrder(tree.left);
		preOrder(tree.right);
	}
	
	private static void preOrderNonReCurSive(TreeNode tree) {
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
	private static void inOrder(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		inOrder(tree.left);
		System.out.print(tree.val);
		inOrder(tree.right);
	}
	
	private static void inOrderNonRecursive(TreeNode tree) {
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
	private static void postOrder(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		postOrder(tree.left);
		postOrder(tree.right);
		System.out.print(tree.val);
	}
	
	private static void postOrderNonReCurSive(TreeNode tree) {
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
