package com.hao.offer;

import com.hao.common.TreeNodeWithParent;

/**
 * 
 * 【面试题8】
 * 【中序遍历的下一个结点】
 * @author hao
 *
 */
public class Offer008 {
	public static void main(String[] args) {
		test1();
	}
	
	public static TreeNodeWithParent GetNext(TreeNodeWithParent tree) {
		return Solution1(tree);
	}
	
	private static TreeNodeWithParent Solution1(TreeNodeWithParent tree) {
		if(tree == null) {
			return null;
		}
		TreeNodeWithParent p = tree;
		
		if(p.right!=null) {
			p = p.right;
			while(p.left!=null) {
				p=p.left;
			}
			return p;
		}
		while(p.parent!=null) {
			if(p == p.parent.left) {
				return p.parent;
			}
			p=p.parent;
		}
		return null;
	}
	
	private static  void test1() {
        TreeNodeWithParent node1 = new TreeNodeWithParent(1);
        TreeNodeWithParent node2 = new TreeNodeWithParent(2);
        TreeNodeWithParent node3 = new TreeNodeWithParent(3);
        TreeNodeWithParent node4 = new TreeNodeWithParent(4);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node4.left=node1;
        node1.parent=node4;
        TreeNodeWithParent nextNodeOf1=GetNext(node1);
        TreeNodeWithParent nextNodeOf2=GetNext(node2);
        TreeNodeWithParent nextNodeOf3=GetNext(node3);
        TreeNodeWithParent nextNodeOf4=GetNext(node4);
        if(nextNodeOf1!=null)
            System.out.println("1结点的下一个结点值为："+nextNodeOf1.val);
        else
            System.out.println("1结点无下一结点");
        if(nextNodeOf2!=null)
            System.out.println("2结点的下一个结点值为："+nextNodeOf2.val);
        else
            System.out.println("2结点无下一结点");
        if(nextNodeOf3!=null)
            System.out.println("3结点的下一个结点值为："+nextNodeOf3.val);
        else
            System.out.println("3结点无下一结点");
        if(nextNodeOf4!=null)
            System.out.println("4结点的下一个结点值为："+nextNodeOf4.val);
        else
            System.out.println("4结点无下一结点");
    }
}
