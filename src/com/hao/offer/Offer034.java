package com.hao.offer;

import java.util.ArrayList;

import com.hao.common.TreeNode;

/**
 * 【面试题34】 【二叉树中和为某一值的路径】
 *  输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *  路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *  (注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * @author hao
 *
 */
public class Offer034 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	 public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		
	     return Solution1(root,target);
	 }

	 
	
	private static ArrayList<ArrayList<Integer>> Solution1(TreeNode root,int target) {
		
		ArrayList<ArrayList<Integer>> pathList=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return pathList;
        ArrayList<Integer> nodeList=new ArrayList<Integer>();
        findPathCore(root,target,pathList,nodeList);
        return pathList;
	}
	
	private static  void findPathCore(TreeNode root,int target,ArrayList<ArrayList<Integer>> pathList,  ArrayList<Integer> nodeList) {
		if(root == null) return;
		nodeList.add(root.val);
		target-=root.val;
		if(target==0 && root.left==null && root.right==null) {
			int i=0;
			while(i<pathList.size() && nodeList.size()<pathList.get(i).size()) {
				i++;
			}
			pathList.add(i,new ArrayList<Integer>(nodeList));
		}else {
			 findPathCore(root.left, target,pathList,nodeList);
			 findPathCore(root.right, target,pathList,nodeList);
		}
		nodeList.remove(nodeList.size()-1);
	}
	
	
	
	/**
	 * 牛客网 
	 */
	private  ArrayList<Integer> nodeList= new ArrayList<>();
	private  ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> Solution3(TreeNode root,int target) {
        if(root==null) {
			return pathList;
		}
		nodeList.add(root.val);
		target -= root.val;
		if(target==0 && root.left==null && root.right==null) {
			int i=0;
			while(i<pathList.size() && nodeList.size()<pathList.get(i).size()) {
				i++;
			}
			pathList.add(i,new ArrayList<Integer>(nodeList));
		}else {
			pathList = FindPath(root.left, target);
			pathList = FindPath(root.right, target);
		}
		nodeList.remove(nodeList.size()-1);
		return pathList;
    }

	
	private static void test1() {
		TreeNode  root = new TreeNode(8);
		TreeNode  node1 = new TreeNode(6);
		TreeNode  node2 = new TreeNode(10);
		TreeNode  node3 = new TreeNode(5);
		TreeNode  node4 = new TreeNode(7);
		TreeNode  node5 = new TreeNode(9);
		TreeNode  node6 = new TreeNode(11);
		root.left=node1;
		root.right=node2;
		node1.left=node3;
		node1.right=node4;
		node2.left=node5;
		node2.right=node6;
		TreeNode.preOrder(root);
		System.out.println();
		
		ArrayList<ArrayList<Integer>> findPath = FindPath(root, 27);
		System.out.println(findPath);
		
		

	}
	private static void test2() {

	}
	private static void test3() {

	}

}