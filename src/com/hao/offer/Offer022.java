package com.hao.offer;

import com.hao.common.ListNode;

/**
 * 【面试题22】 【链表中倒数第k个结点】 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author hao
 *
 */
public class Offer022 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	public static ListNode FindKthToTail(ListNode head, int k) {
		return Solution1(head, k);
	}

	/**
	 * 双指针的方法
	 * @param head
	 * @param k
	 * @return
	 */
	private static ListNode Solution1(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}
		ListNode pBefore = head;
		ListNode pBeHind = null;

		for (int i = 0; i < k - 1; i++) {
			if (pBefore.next != null) {
				pBefore = pBefore.next;
			} else {
				return null;
			}
		}
		pBeHind = head;
		while (pBefore.next != null) {
			pBefore = pBefore.next;
			pBeHind = pBeHind.next;
		}
		return pBeHind;
	}

	private static void test1() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode kthNode = FindKthToTail(head, 4);
		System.out.println("{1,2,3,4},4 ---> " + kthNode.val);
	}

	private static void test2() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode kthNode = FindKthToTail(head, 5);
		if (kthNode == null) {
			System.out.println("{1,2,3,4},5---> null ");
		} else {
			System.out.println("测试失败！");
		}
	}

	private static void test3() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode kthNode = FindKthToTail(head, 0);
		if (kthNode == null) {
			System.out.println("{1,2,3,4},0---> null ");
		} else {
			System.out.println("测试失败！");
		}
	}

	private static void test4() {
		ListNode head = null;
		ListNode kthNode = FindKthToTail(head, 4);
		if (kthNode == null) {
			System.out.println("{null},4---> null ");
		} else {
			System.out.println("测试失败！");
		}
	}
}
