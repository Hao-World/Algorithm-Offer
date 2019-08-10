package com.hao.offer;

import com.hao.common.ListNode;

/**
 * 【面试题25】 【合并两个排序的链表】 输入两个**递增排序**的链表，**合并**这两个链表并使新链表中的节点仍然是递增排序的。
 * 
 * @author hao
 *
 */
public class Offer25 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	public static ListNode Merge(ListNode l1, ListNode l2) {
		return Solution3(l1, l2);
	}

	private static ListNode Solution1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head = new ListNode(-1);
		ListNode p = head;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
			if (l1 == null) {
				p.next = l2;
			} else {
				p.next = l1;
			}
		}
		return head.next;
	}

	private static ListNode Solution2(ListNode l1, ListNode l2) {
		ListNode pHead = new ListNode(-1);
		ListNode p = pHead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 == null) {
			p.next = l2;
		} else {
			p.next = l1;
		}
		return pHead.next;
	}

	/**
	 * 递归的方法
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static ListNode Solution3(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val <= l2.val) {
			l1.next = Solution3(l1.next, l2);
			return l1;
		} else {
			l2.next = Solution3(l1, l2.next);
			return l2;
		}

	}

	private static void test1() {
		ListNode l1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(11);
		l1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode l2 = new ListNode(4);
		ListNode node22 = new ListNode(6);
		ListNode node23 = new ListNode(8);
		ListNode node24 = new ListNode(13);
		l2.next = node22;
		node22.next = node23;
		node23.next = node24;
		System.out.println("链表1：");
		ListNode.printListNode(l1);
		System.out.println("链表2");
		ListNode.printListNode(l2);

		ListNode merge = Merge(l1, l2);
		System.out.println("合并的链表--->");
		ListNode.printListNode(merge);

	}

	private static void test2() {
		ListNode l1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		l1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode l2 = new ListNode(1);
		ListNode node22 = new ListNode(5);
		ListNode node23 = new ListNode(5);
		ListNode node24 = new ListNode(8);
		l2.next = node22;
		node22.next = node23;
		node23.next = node24;
		System.out.println("链表1：");
		ListNode.printListNode(l1);
		System.out.println("链表2");
		ListNode.printListNode(l2);

		ListNode merge = Merge(l1, l2);
		System.out.println("合并的链表--->");
		ListNode.printListNode(merge);

	}

	private static void test3() {
		ListNode l1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(7);
		l1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		System.out.println("链表1：");
		ListNode.printListNode(l1);
		ListNode l2 = null;
		System.out.println("链表2");
		ListNode.printListNode(l2);

		ListNode merge = Merge(l1, l2);
		System.out.println("其中类l2为null,合并的链表--->");
		ListNode.printListNode(merge);
	}

	private static void test4() {
		System.out.println("都为null，合并链表--->");
		ListNode merge = Merge(null, null);
		ListNode.printListNode(merge);
	}

}
