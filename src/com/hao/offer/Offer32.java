package com.hao.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.hao.common.TreeNode;

/**
 * 【面试题32】 【不分行从上到下打印二叉树】 
 * 从上到下打印出二叉树的每个节点，同层的节点按照从左到右的顺序打印
 * 
 * 
 * @author hao
 *
 */
public class Offer32 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static  List PrintFromTopToBottom(TreeNode root) {
			return Solution3(root);
	}

	private static ArrayList<Integer>  Solution1(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        TreeNode node = null;
        while(queue.size()!=0){
            node = queue.poll();
            list.add(node.val);
            if(node.left!=null){
               queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
  
        }
        return list;
	}
	
	private static  ArrayList<ArrayList<Integer>> Solution2(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> levelList = null;
        if(root == null){
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int nextLevel= 1; //下层节点个数
        int toBePrinted = 0 ;//当前层还需要打印的节点个数
        TreeNode node =null;
        while(queue.size()!=0){
            toBePrinted = nextLevel;
            nextLevel = 0;
            levelList = new ArrayList<Integer>();
            for(int i=1;i<=toBePrinted;i++){
                node = queue.pop();
                levelList.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                    nextLevel ++ ;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    nextLevel ++ ;
                }
            }
            list.add(levelList);
        }
        return list;   
	}
	
	private static ArrayList<ArrayList<Integer>> Solution3(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> levelList = null;
		if(root==null) {
			return list;
		}
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		TreeNode node =null;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			
			
			if(!stack1.isEmpty()) {
				levelList = new ArrayList<>();
				while(!stack1.isEmpty()) {
					node = stack1.pop();
					levelList.add(node.val);
					if(node.left!=null) {
						stack2.push(node.left);
					}
					if(node.right!=null) {
						stack2.push(node.right);
					}
				}
				list.add(levelList);
			}else {
				levelList = new ArrayList<>();
				while(!stack2.isEmpty()) {
					node = stack2.pop();
					levelList.add(node.val);
					if(node.right!=null) {
						stack1.push(node.right);
					}
					if(node.left!=null) {
						stack1.push(node.left);
					}
				}
				list.add(levelList);
			}
			
			
		}
		return list;
		
	}

	@SuppressWarnings("unused")
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
		ArrayList<ArrayList<Integer>> list = (ArrayList<ArrayList<Integer>>) PrintFromTopToBottom(root);
//		Solution3(root);
		System.out.println(list);
	}
	


	private static void test2() {

	}

	private static void test3() {

	}

}