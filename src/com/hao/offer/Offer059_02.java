package com.hao.offer;

import java.util.ArrayDeque;

/**
 * 【面试题59-2】 【队列的最大值】 请定义一个队列并实现函数max得到队列里的最大值， 要求函数max、push_back和 pop_front
 * 的时间复杂度都是0(1)。
 * 
 * @author hao
 *
 */
public class Offer059_02 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	private ArrayDeque<InternalData> data = new ArrayDeque<InternalData>();
	private ArrayDeque<InternalData> maximum = new ArrayDeque<InternalData>();

	private class InternalData {
		int number;
		int index;

		public InternalData(int number, int index) {
			this.number = number;
			this.index = index;
		}
	}

	private int curIndex;

	public void push_back(int number) {
		InternalData curData = new InternalData(number, curIndex);
		data.addLast(curData);

		while (!maximum.isEmpty() && maximum.getLast().number < number)
			maximum.removeLast();
		maximum.addLast(curData);

		curIndex++; // 别漏了这句
	}

	public void pop_front() {
		if (data.isEmpty()) {
			System.out.println("队列为空，无法删除！");
			return;
		}
		InternalData curData = data.removeFirst();
		if (curData.index == maximum.getFirst().index)
			maximum.removeFirst();
	}

	public int max() {
		if (maximum == null) {
			System.out.println("队列为空，无法删除！");
			return 0;
		}
		return maximum.getFirst().number;
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}

}