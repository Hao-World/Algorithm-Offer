package com.hao.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 【面试题41】 【数据流中的中位数】
 *  
 *  
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 * @author hao
 *
 */
public class Offer041 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	int k = 11;
	PriorityQueue<Integer> minQ = new PriorityQueue<Integer>(); // 小顶堆，存中位数右边的数，都大
	PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
			return o2.compareTo(o1);
		}
	});

	private int count =0;
	public void Insert(Integer num) {
		count++;
		if ((count & 1) == 0) {// 插入的数量为偶数 要插入右边的最小堆中
			if (!maxQ.isEmpty() && num < maxQ.peek()) {// 大顶堆不为空 插入值小于左边最大堆中的数
				maxQ.offer(num); //将此值插入到大顶推中
				num = maxQ.poll(); // 把大顶堆中的最大值插入到小顶堆中
			}
			minQ.add(num);
		} else {// 奇数 插入左边最大堆
			if (!minQ.isEmpty() && num > minQ.peek()) {
				minQ.offer(num);
				num = minQ.poll();
			}
			maxQ.offer(num);
		}

	}

	public Double GetMedian() {
		if (count == 0)
			throw new RuntimeException("error!");
		double dd;
		if ((count & 1) == 0) {
			dd = (minQ.peek() + maxQ.peek())/2.0; // n偶数 取大顶堆和小顶堆的堆顶值／2
		} else
			dd = maxQ.peek(); // n为奇数 取小顶堆的最大值。
		return dd;
	}
	private static void test1() {

	}
	private static void test2() {

	}
	private static void test3() {

	}
}