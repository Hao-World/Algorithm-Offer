package com.hao.offer;

import java.util.Stack;

/**
 * 【面试题31】 【栈的压入、弹出序列】 
 * 输入两个整数序列，第一个序列表示栈的**压入顺序**，
 * 请**判断**第二个序列**是否**为该栈的**弹出顺序**。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列{1,2,3,4,5}是某栈的压栈序列，
 * 序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列，
 * 但{4,3,5,1,2}就不可能是该压栈序列的弹出序列。
 * 
 * @author hao
 *
 */
public class Offer031 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		return Solution1(pushA,popA);
	}

	private  static boolean Solution1(int[] pushA, int[] popA) {
		if(pushA==null || popA==null){
	          return false;
	        }
	        if(pushA.length!=popA.length || pushA.length==0){
	          return false;
	        }
	        Stack<Integer> stack = new Stack<Integer>();
	        int popIndex  = 0;
	        for(int pushIndex=0;pushIndex<pushA.length;pushIndex++){
	            stack.push(pushA[pushIndex]);
	            while(!stack.empty()&&stack.peek()==popA[popIndex]){
	                stack.pop();
	                popIndex++;
	            }
	        }
	        return stack.empty();
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}
}