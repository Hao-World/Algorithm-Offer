package com.hao.offer;

import com.hao.common.RandomListNode;

/**
 * 【面试题35】 【复杂链表的复制】
 *  　输入一个**复杂链表**（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 *  另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 *  （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author hao
 *
 */
public class Offer35 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static  RandomListNode Clone(RandomListNode pHead)
    {
		return Solution1(pHead);
        
    }

	private static  RandomListNode Solution1(RandomListNode pHead) {
		cloneNodes(pHead);
		connectSlibNodes(pHead);
		return reconnectNodes(pHead);
	}

	
	 private static void cloneNodes(RandomListNode pHead){
	        RandomListNode pNode = pHead;
	        while(pNode!=null){
	            RandomListNode pClonedNode = new RandomListNode(pNode.label);
	            pClonedNode.next = pNode.next;
	            pClonedNode.random = null;
	            pNode.next = pClonedNode;
	            pNode = pClonedNode.next;
	        }
	        
	    }
	    private static void connectSlibNodes(RandomListNode pHead){
	        RandomListNode pNode = pHead;
	        while(pNode!=null){
	            RandomListNode pClonedNode = pNode.next;
	            if(pNode.random!=null){
	                 pClonedNode.random = pNode.random.next;
	            }
	            pNode = pClonedNode.next;
	        }
	    }
	    private  static RandomListNode reconnectNodes(RandomListNode pHead){
	        RandomListNode pNode = pHead;
	        RandomListNode pClonedHead = null;
	        RandomListNode pClonedNode = null;
	        if(pNode!=null){
	            pClonedHead = pClonedNode = pNode.next;
	            pNode.next = pClonedNode.next;
	            pNode = pClonedNode.next;
	        }
	        while(pNode!=null){
	            pClonedNode.next = pNode.next;
	            pClonedNode = pClonedNode.next;
	            pNode.next = pClonedNode.next;
	            pNode = pNode.next;
	        }
	        return pClonedHead;
	    }

	

	
	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}