package com.hao.offer;

/**
 * 【面试题50-2】 【字符流中第一个只出现一次的字符】 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * @author hao
 *
 */
public class Offer050_02 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();

	}
	
	private int index;
	private int[] occurence;
	
	public Offer050_02() {
		index=0;
        occurence = new int[256];
        for(int i=0;i<256;i++) {
            occurence[i]=-1;
        }
	}

	// Insert one char from stringstream
	public void Insert(char ch) {
		if(occurence[(int)ch]==-1) {
            occurence[(int)ch]=index;   //第一次出现
        }else if(occurence[(int)ch]>=0) {
            occurence[(int)ch]=-2;   //已经出现过了
        }
        index++;
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		int minIndex=Integer.MAX_VALUE;  //最大的integer
        char ch='#';
        for(int i=0;i<256;i++) {
            if(occurence[i]>=0 && occurence[i]<minIndex) {
                ch = (char) i;
                minIndex=occurence[i];
            }
        }
        return ch;
	}

	private static void test1() {
	}
	private static void test2() {
	}
	private static void test3() {
	}
}