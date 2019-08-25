package com.hao.offer;

/**
 * 【面试题51】 【数组中的逆序对】 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。 例如，在数组{7,5,6,4}中，一共存在5个逆序对，分别是(7, 6)、(7,5)、(7,4)、(6,
 * 4)和(5, 4)。
 * 
 * @author hao
 *
 */
public class Offer051 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}

	public static int inversePairs(int[] array) {
		return Solution1(array);
	}

	private static int Solution1(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int count = getCount(array, 0, array.length - 1);
		return count;
	}

	private static int getCount(int[] array,int start,int end){
        if(start>=end)
            return 0;
        int mid=(end+start)>>1;
        int left=getCount(array,start,mid)%1000000007;
        int right=getCount(array,mid+1,end)%1000000007;
         
        //合并
        int count=0;
        int i=mid; //左边区域的指针
        int j=end; //右边区域的指针
        int[] temp= new int[end-start+1];  //临时区域
        int k=end-start; //临时区域的指针
        while(i>=start && j>=mid+1){
            if(array[i]>array[j]){
                count+=(j-mid);
                temp[k--]=array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }else{
                temp[k--]=array[j--];
            }
        }
        while(i>=start)
            temp[k--]=array[i--];
        while(j>=mid+1)
            temp[k--]=array[j--];
        for(k=0;k<temp.length;k++)
            array[k+start]=temp[k];
         
        return (count+left+right)%1000000007;
    }

	private static void test1() {

	}

	private static void test2() {

	}

	private static void test3() {

	}
}