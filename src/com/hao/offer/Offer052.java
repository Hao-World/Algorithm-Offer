package com.hao.offer;

import com.hao.common.ListNode;

/**
 * 【面试题52】 【两个链表的第一个公共节点】
 *  题目:输入两个链表，找出它们的第一个公共节点。
 * 
 * @author hao
 *
 */
public class Offer052 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
	     return Solution1(pHead1,pHead2);
    }

	/**
	 * 利用长度关系
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	private static ListNode Solution1(ListNode pHead1, ListNode pHead2) {
		int listLength1 = getListLength(pHead1);
		int listLength2 = getListLength(pHead2);
		int dif = listLength1-listLength2;
		ListNode longList = pHead1;
		ListNode shortList = pHead2;
		if(listLength1<listLength2) {
			longList = pHead2;
			shortList = pHead1;
			dif = listLength2-listLength1;
		}
		for(int i=0;i<dif;i++) {
			longList = longList.next;
		}
		while(longList!=null && shortList!=null && longList!=shortList) {
			longList = longList.next;
			shortList = shortList.next;
		}
		ListNode firstCommonFirst = longList;
		
		return firstCommonFirst;
	}
	
	

	private static int getListLength(ListNode pHead1) {
		int length = 0;
		while(pHead1!=null) {
			length++;
			pHead1 = pHead1.next;
		}
		return length;
	}

	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}