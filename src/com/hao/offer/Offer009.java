package com.hao.offer;

import java.util.Stack;

/**
 * 【面试题9】 【用两个栈实现队列】
 * 
 * @author hao
 *
 */
public class Offer009 {
	public static void main(String[] args) {

	}

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}
	
	    throw new IllegalStateException("队列为空");
		
	}

}
