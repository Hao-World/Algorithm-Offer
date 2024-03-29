package com.hao.offer;

import java.util.ArrayList;
import java.util.Stack;

import com.hao.common.ListNode;

/**
 * 【面试题6】 【从尾到头打印链表】 将其添加到ArrayList当中输出
 * 
 * @author hao
 *
 */
public class Offer006 {
	public static void main(String[] args) {

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(9);
		ListNode ListNode4 = new ListNode(6);
		ListNode ListNode5 = new ListNode(99);
		ListNode1.next = ListNode2;
		ListNode2.next = ListNode3;
		ListNode3.next = ListNode4;
		ListNode4.next = ListNode5;
		ArrayList<Integer> result = Offer006.printListFromTailToHead(ListNode1);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		return Solution3(listNode);
	}

	// =================******** 题 解 **************======================
	// 此处要声明一个成员变量list用来存放 链表中的值
	private static ArrayList<Integer> list = new ArrayList<Integer>();

	/**
	 * 递归的方法
	 * 
	 * @param listNode
	 * @return
	 */
	private static ArrayList<Integer> Solution1(ListNode listNode) {
		if (listNode != null) {
			Solution1(listNode.next);
			list.add(listNode.val);
		}
		return list;
	}

	/**
	 * 利用栈，占中存放ListNode
	 * 
	 * @param listNode
	 * @return
	 */
	private static ArrayList<Integer> Solution2(ListNode listNode) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while (listNode != null) {
			stack.push(listNode);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop().val);
		}
		return list;
	}

	/**
	 * 利用栈 栈中存放值
	 * 
	 * @param listNode
	 * @return
	 */
	private static ArrayList<Integer> Solution3(ListNode listNode) {
		Stack<Integer> stack = new Stack<Integer>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}

		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}

}
