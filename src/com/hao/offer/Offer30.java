package com.hao.offer;

import java.util.Stack;

/**
 * 【面试题30】 【包含min函数的栈】 模版
 * 
 * @author hao
 *
 */
public class Offer30 {

	Stack<Integer> stack_min = new Stack<Integer>();// 存储最小值的辅助栈
	Stack<Integer> stack_data = new Stack<Integer>();// 存储栈中数据

	public void push(int node) {
		stack_data.push(node);

		if (stack_min.isEmpty() || node < stack_min.peek()) {
			stack_min.push(node);
		} else {
			stack_min.push(stack_min.peek());
		}

	}

	public void pop() {
		if (!stack_data.isEmpty()) {
			stack_data.pop();
			stack_min.pop();
		}
	}

	public int top() {
		return stack_data.peek();
	}

	public int min() {
		return stack_min.peek();
	}

}