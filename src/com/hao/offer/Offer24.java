package com.hao.offer;

import com.hao.common.ListNode;

/**
 * 【面试题24】 【反转链表】 题目:定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 
 * @author hao
 *
 */
public class Offer24 {
	public static void main(String[] args) {	
		test1();
		test2();
		test3();
	}

	public static ListNode ReverseList(ListNode head) {

		return Solution1(head);
	}

	private static ListNode Solution1(ListNode head) {
		ListNode pReverseHead = null;
		ListNode pre = null;
		ListNode p = head;
		ListNode pNext = null;
		while (p != null) {
			pNext = p.next;
			if (pNext == null) {
				pReverseHead = p;
			}
			p.next = pre;
			pre = p;
			p = pNext;
		}
		return pReverseHead;
	}

	/**
	 * 利用头插法 的思想
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode Solution2(ListNode head) {
		
		ListNode pHead = new ListNode(-1);// 设置一个头结点；
		pHead.next = null; // 头结点 next设置为null
		ListNode p = head;
		ListNode r = null; // 指向下一个节点
		while (p != null) {
			r = p.next;
			p.next = pHead.next;
			pHead.next = p;
			p = r;
		}
		return pHead.next;
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
		System.out.println("反转之前");
		ListNode.printListNode(node1);
		System.out.println("反转之后");
		ListNode reverseList = ReverseList(node1);
		ListNode.printListNode(reverseList);
	}
	
	private static void test2() {
		ListNode node1 = new ListNode(1);
		System.out.println("反转之前");
		ListNode.printListNode(node1);
		System.out.println("反转之后");
		ListNode reverseList = ReverseList(node1);
		ListNode.printListNode(reverseList);
	}
	
	private static void test3() {
		ListNode node1 = null;
		System.out.println("反转之前");
		ListNode.printListNode(node1);
		System.out.println("反转之后");
		ListNode reverseList = ReverseList(node1);
		ListNode.printListNode(reverseList);
	}
	
}
