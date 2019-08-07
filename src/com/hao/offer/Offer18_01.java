package com.hao.offer;

import com.hao.common.ListNode;

/**
 * 【面试题18】 【删除单链表中节点】 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 
 * @author hao
 *
 */
public class Offer18_01 {
	public static void main(String[] args) {
		System.out.println("****功能测试***");
		test1();
		System.out.println("***仅有一个节点元素的单链表测试***");
		test2();
		System.out.println("***特殊输入测试****");
		test3();
	}

	public static ListNode deleteNodeInList(ListNode pHead, ListNode pdelNode) {
		return Solution1(pHead, pdelNode);
	}

	/**
	 * 如果要删除的节点是中间节点，我们可以直接将它后面的一个节点的值赋给它， 而要删除的节点就变成了它后面的一个节点，
	 * 要考虑删除节点是尾结点，和链表中只有一个节点的情况
	 * 
	 * @param pHead
	 * @param pdelNode
	 * @return
	 */
	private static ListNode Solution1(ListNode pHead, ListNode pdelNode) {
		if (pHead == null || pdelNode == null) {
			return pHead;
		}
		if (pdelNode.next != null) {// 要删除的节点在链表中间位置
			ListNode p = pdelNode.next;
			pdelNode.val = p.val;
			pdelNode.next = p.next;
			p = null;
		} else if (pHead.next == pdelNode) {// 链表只有一个结点
			pHead.next = pdelNode.next;
			pdelNode = null;
		} else {// 链表中有多的节点，要删除的节点是尾结点
			ListNode p = pHead;
			while (p.next != pdelNode) {// 搜寻pdelNode的前一个节点
				p = p.next;
			}
			p.next = pdelNode.next;
			pdelNode = null;
		}
		return pHead;
	}

	/**
	 * 功能测试
	 */
	private static void test1() {//
		System.out.println("(不加头结点)有三个节点元素的单链表");
		ListNode node3 = new ListNode(9, null);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(4, node2);
		ListNode pHead = new ListNode(-1, node1);// 头结点
		System.out.println("删除之前");
		ListNode.printListNodeWithHead(pHead);
		System.out.println("删除之后--->");
		deleteNodeInList(pHead, node2);
		ListNode.printListNodeWithHead(pHead);
	}

	private static void test2() {//
		System.out.println("(不加头结点)仅有一个节点元素的单链表");
		ListNode node1 = new ListNode(4, null);
		ListNode pHead = new ListNode(-1, node1);// 头结点
		System.out.println("删除之前");
		ListNode.printListNodeWithHead(pHead);
		System.out.println("删除之后-->");
		deleteNodeInList(pHead, node1);
		ListNode.printListNodeWithHead(pHead);
	}

	/**
	 * 特殊输入测试
	 */
	private static void test3() {//
		System.out.println("(不加头结点)有三个节点元素的单链表");
		ListNode node3 = new ListNode(9, null);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(4, node2);
		ListNode pHead = new ListNode(-1, node1);// 头结点
		System.out.println("删除之前");
		ListNode.printListNodeWithHead(pHead);
		System.out.println("删除之后(传入参数为null，null)--->");
		deleteNodeInList(null, null);
		ListNode.printListNodeWithHead(pHead);
	}

	

}
