package com.hao.offer;

/**
 * 【面试题53】 【数字在排序数组中出现的次数】 统计一个数字在排序数组中出现的次数。
 * 例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 * 
 * @author hao
 *
 */
public class Offer053_01 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static int GetNumberOfK(int[] array, int k) {
		return Solution1(array, k);
	}

	private static int Solution1(int[] array, int k) {
		if (array == null || array.length <= 0) {
			return 0;
		}
		int firstK = getFirstK(array, 0, array.length - 1, k);
		if (firstK == -1) {
			return 0;
		}
		int lastK = getLastK(array, 0, array.length - 1, k);

		return lastK - firstK + 1;
		
	}
	
	private static int getFirstK(int[] array,int start,int end,int k) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)>>1;
		if(array[mid]==k) {
			if(mid==0 || array[mid-1]!=k) {
				return mid;
			}else {
				end = mid-1;
			}
		}else if(array[mid]<k) {
			start = mid+1;
		}else {
			end = mid-1;
		}
		return getFirstK(array, start, end, k);
	}
	
	private static int getLastK(int[] array,int start,int end,int k) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)>>1;
		if(array[mid]==k) {
			if(mid==array.length-1 || array[mid+1]!=k) {
				return mid;
			}else {
				start = mid+1;
			}
			
		}else if(array[mid]<k) {
			start = mid+1;
		}else {
			end = mid-1;
		}
		return getLastK(array, start, end, k);
	}

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}

}