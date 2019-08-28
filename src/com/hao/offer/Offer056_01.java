package com.hao.offer;

/**
 * 【面试题56-1】 【数组中只出现一次的两个数字】
 * 
 * 一个整型数组里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是0(1)。
 * 
 * @author hao
 *
 */
public class Offer056_01 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		Solution1(array,num1,num2);
	}

	

	private static void Solution1(int[] array, int[] num1, int[] num2) {
		if(array==null || array.length<2){
            return;
        }
        int resultExcuOR = 0;
        for(int i=0;i<array.length;i++){
            resultExcuOR ^= array[i];
        }
        int indexOf1 = 0;
        while( ((resultExcuOR&1)==0) && indexOf1<=4*8){ 
            resultExcuOR = resultExcuOR>>1;
            indexOf1++;
        }
        
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
            if(isBit1(array[i],indexOf1)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
	}

	private static boolean isBit1(int num, int indexOf1) {
		num = num>>indexOf1;
        return (num&1)==1;
	}
	
	private static void test1() {

	}
	private static void test2() {

	}

	private static void test3() {

	}

}