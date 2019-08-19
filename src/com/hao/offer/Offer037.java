package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题37】 【序列化二叉树】 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 
 * @author hao
 *
 */
public class Offer037 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if (root == null) {
			sb.append("#!");
		} else {
			sb.append(root.val + "!");
			sb.append(Serialize(root.left));
			sb.append(Serialize(root.right));
		}
		return sb.toString();
	}

	int index = 0;

	TreeNode Deserialize(String str) {
		TreeNode node = null;
		int start = index;
		while (str.charAt(index) != '!') {
			index++;
		}
		if (!str.substring(start, index).equals("#")) {
			node = new TreeNode(Integer.parseInt(str.substring(start, index)));
			index++;
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		} else {
			index++;
		}
		return node;
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}

}