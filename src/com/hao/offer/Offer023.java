package com.hao.offer;

import com.hao.common.ListNode;

/**
 * 【面试题23】 一个链表中包含环，如何找出环的入口结点？ ----------- | | 1-->2-->3-->4-->5-->6
 * 
 * @author hao
 *
 */
public class Offer023 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	public static ListNode EntryNodeOfLoop(ListNode head) {
		return Solution1(head);
	}

	/**
	 * 1.判断链表中是否有环，并找出环中节点个数n 2.将一个指针向前移动n，另个一指针指向头节点 3. 然后同时移动两个指针，两个指针相遇时，就是环的入口
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode Solution1(ListNode head) {
		if (head == null) {
			return null;
		}
		// 判断链表中是否有环，并找到快慢指针相遇的节点
		ListNode meetNode = MeetingNode(head);
		if (meetNode == null) {// 说明链表中没有环
			return null;
		}
		int count = 1; // 统计环中节点的个数
		ListNode pLoop = meetNode;
		while (pLoop.next != meetNode) {
			pLoop = pLoop.next;
			++count;
		}

		ListNode p1 = head;
		for (int i = 0; i < count; i++) {
			p1 = p1.next;
		}
		ListNode p2 = head;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

	/**
	 * 设置两个指针，快指针一次走两步，慢指针一次走一步 如果快指针 追上了慢指针，就说明有环
	 * 如果快指针走到尾部(null)时两个指针没有相遇，就说明两个指针没有环存在，
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode MeetingNode(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode pSlow = head.next;
		if (pSlow == null) {
			return null;
		}
		ListNode pFast = pSlow.next;

		while (pSlow != null && pFast != null) {
			if (pSlow == pFast) {
				return pFast;
			}
			pSlow = pSlow.next;
			pFast = pFast.next;
			if (pFast != null) {
				pFast = pFast.next;
			}
		}
		return null;
	}

	private static void test1() {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;

		System.out.println("链表中有环而且有多个节点(>=3)---->");
		ListNode entryLoop = EntryNodeOfLoop(node1);
		if (entryLoop != null) {
			System.out.println(entryLoop.val);
		} else {
			System.out.println("null");
		}
	}

	private static void test2() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		System.out.println("链表中没有环---->");
		ListNode entryLoop = EntryNodeOfLoop(node1);
		if (entryLoop != null) {
			System.out.println(entryLoop.val);
		} else {
			System.out.println("null");
		}
	}

	private static void test3() {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		node2.next = node1;

		ListNode entryLoop = EntryNodeOfLoop(node1);
		System.out.println("链表中有环，只有有两个个节点---->");
		if (entryLoop != null) {
			System.out.println(entryLoop.val);
		} else {
			System.out.println("null");
		}
	}

	private static void test4() {

		ListNode node1 = new ListNode(1);
		node1.next = node1;

		ListNode entryLoop = EntryNodeOfLoop(node1);
		System.out.println("链表中有环，只有一个节点---->");
		if (entryLoop != null) {
			System.out.println(entryLoop.val);
		} else {
			System.out.println("没有环");
		}
	}

	private static void test5() {
		ListNode entryLoop = EntryNodeOfLoop(null);
		System.out.println("传入null---->");
		if (entryLoop != null) {
			System.out.println(entryLoop.val);
		} else {
			System.out.println("null");
		}
	}

}
