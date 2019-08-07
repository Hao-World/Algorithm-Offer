package com.hao.common;

/**
 * 单链表结点
 * @author hao
 *
 */
public class ListNode {
	public int val;
	public ListNode next = null;
	public ListNode(int val) {
		this.val = val;
	}
	public ListNode(int val,ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	
	/**
	 * 打印链表 有头节点
	 * 
	 * @param pHead
	 */
	public static void printListNodeWithHead(ListNode pHead) {
		ListNode p = pHead.next;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	
	/**
	 * 打印链表 此题目没有头结点
	 * 
	 * @param pHead
	 */
	public  static void printListNode(ListNode pHead) {
		ListNode p = pHead;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
	

	
}
