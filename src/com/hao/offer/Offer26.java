package com.hao.offer;

import com.hao.common.TreeNode;

/**
 * 【面试题26】 【树的子结构】 输入两棵二叉树A和B,判断B是不是A的子结构。图中右边的树是左边的子结构
 * 
 * @author hao
 *
 */
public class Offer26 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
		return Solution1(root1, root2);
	}

	/**
	 * 在树A中找到与树B中根节点值一样节点
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	private static boolean Solution1(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (isEqusl(root1.val, root2.val)) {
				result = DoesTreeHaveTree2(root1, root2);
			}
			if (!result) {
				result = Solution1(root1.left, root2);
			}
			if (!result) {
				result = Solution1(root1.right, root2);
			}
		}
		return result;
	}

	/**
	 * 此方法用于判断树A中**以R为根结点**的子树是否包含B树一样的结构。
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	private static boolean DoesTreeHaveTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (!isEqusl(root1.val, root2.val)) {
			return false;
		}
		return DoesTreeHaveTree2(root1.left, root2.left) && DoesTreeHaveTree2(root1.right, root2.right);
	}

	/**
	 * 浮点数比较大小
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static boolean isEqusl(float num1, float num2) {
		final float THRESHOLD = 0.000001f;
		if (Math.abs(num1 - num2) < THRESHOLD) {
			return true;
		} else {
			return false;
		}
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}

}