package com.hao.offer;

import com.hao.common.ListNode;

/**
 * 【面试题18】 【删除链表中重复的节点】 在一个排序的链表中，存在重复的结点， 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * @author hao
 *
 */
public class Offer18_02 {

	public static void main(String[] args) {
		System.out.println("****功能测试***");
		test1();
		System.out.println("***特殊输入测试****");
		test2();
		System.out.println("***特殊输入测试****");
		test3();
	}

	public static ListNode deleteDuplication(ListNode pHead) {
		return Solution1(pHead);
	}

	/**
	 * 
	 * 需要设置三个指针，pre pNode 和 next ;
	 * 
	 * @param pHead
	 * @return
	 */
	private static ListNode Solution1(ListNode pHead) {
		if (pHead == null || pHead.next == null) {// 如果链表为空，或者已有一个节点
			return pHead;
		}
		ListNode pre = null;
		ListNode pNode = pHead; // 代表当前节点
		while (pNode != null) {// 从头指针开始遍历链表
			boolean needDel = false;
			ListNode pNext = pNode.next;
			if (pNext != null && pNext.val == pNode.val) {
				// 如果当前节点的下一个结点不为null 且其值和当前节点相等
				needDel = true;
			}
			if (!needDel) {// 如果没有找到重复的元素就将指针往后移动
				pre = pNode;
				pNode = pNode.next;
			} else { // 找到重复的元素
				ListNode toBeDel = pNode;
				int value = toBeDel.val;
				while (toBeDel != null && toBeDel.val == value) {
					// 将指针移到所有重复元素的后面
					toBeDel = toBeDel.next;
				}
				if (pre == null) {// 删除的是第一个节点
					pHead = toBeDel;
				} else {
					pre.next = toBeDel;
				}
				pNode = toBeDel;
			}
		}

		return pHead;
	}

	/**
	 * 功能测试 要注意此题目没有头结点
	 */
	private static void test1() {//
		System.out.println("有两对重复的");
		ListNode node6 = new ListNode(6, null);
		ListNode node5 = new ListNode(6, node6);
		ListNode node4 = new ListNode(3, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		ListNode pHead = new ListNode(0, node1);
		System.out.println("删除之前");
		printListNode(pHead);
		System.out.println("删除之后--->");
		deleteDuplication(pHead);
		printListNode(pHead);
	}

	/**
	 * 特殊值输入测试
	 */
	private static void test2() {//
		System.out.println("所有的元素都是重复的");
		ListNode node6 = new ListNode(2, null);
		ListNode node5 = new ListNode(1, node6);
		ListNode node4 = new ListNode(1, node5);
		ListNode node3 = new ListNode(1, node4);
		ListNode node2 = new ListNode(1, node3);
		ListNode node1 = new ListNode(1, node2);
		ListNode pHead = new ListNode(1, node1);
		System.out.println("删除之前");
		printListNode(pHead);
		System.out.println("删除之后--->");
		deleteDuplication(pHead);
		printListNode(pHead);
	}

	private static void test3() {
		System.out.println("只有一个节点");
		ListNode pHead = new ListNode(1, null);
		System.out.println("删除之前");
		printListNode(pHead);
		System.out.println("删除之后--->");
		deleteDuplication(pHead);
		printListNode(pHead);
	}

	/**
	 * 打印链表 此题目没有头结点
	 * 
	 * @param pHead
	 */
	private static void printListNode(ListNode pHead) {
		ListNode p = pHead;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
}
