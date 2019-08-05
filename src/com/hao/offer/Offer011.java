package com.hao.offer;

/**
 * 
 * 
 * 【面试题11】
 * 【旋转数组的最小元素】
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author hao
 *
 */
public class Offer011 {
	public static void main(String[] args) {
//		int [] arr = {3,4,5,1,2};
		int [] arr = {1,0,1,1,1};
		int minNumberInRotateArray = minNumberInRotateArray(arr);
		System.out.println(minNumberInRotateArray);
		
	}
	
	public  static int minNumberInRotateArray(int [] array) {
		return Solution1(array);
	}
	
	/**
	 * 利用二分查找的思路，注意：要考虑特殊情况
	 * @param array
	 * @return
	 */
	public static  int Solution1(int [] array) {
		
		int index1 = 0;
		int index2 = array.length-1;
		int indexMid = index1;
		while(array[index1]>=array[index2]) {
			if(index2-index1==1) {
				indexMid= index2;
				break;
			}
			indexMid = (index1+index2) >>1;
			if(array[index1] == array[index2] && array[indexMid] == array[index1]) {
				//特殊情况：要用顺序查找
				return MinInOrder(array, index1, index2);
			}
			
			if(array[indexMid]>=array[index1]) {
				index1 = indexMid;
			}else if(array[indexMid]<=array[index2]) {
				index2 = indexMid;
			}
		}
		
		
		return array[indexMid];
	}
	/**
	 * 在index1和index2之间顺序查找最小值
	 * @param array 在此数组中进行查找
	 * @param index1  开始索引位置
	 * @param index2  结束索引位置
	 * @return
	 */
	private static int MinInOrder(int[] array,int index1,int index2) {
		int min = array[index1];
		for(int i=index1+1;i<=index2;i++) {
			if(min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}
}
