package com.hao.offer;

/**
 * 【面试题66】 【构建乘积数组】
 * 给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，
 * 其中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 
 * @author hao
 *
 */
public class Offer066 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	 public static int[] multiply(int[] A) {
		return Solution1(A);
	}


	private static int[] Solution1(int[] A) {
		if(A==null || A.length<2)
            return null;
        int[] B=new int[A.length];
        B[0]=1;
        for(int i=1;i<A.length;i++)
            B[i]=B[i-1]*A[i-1];
        int temp=1;
        for(int i=A.length-2;i>=0;i--){
            temp*=A[i+1];
            B[i]*=temp;
        }
        return B;
	}

	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}