package com.hao.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 【面试题45】 【把数组排成最小的数】
 *  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *  例如，输入数组{3,32,321}，则打印出这3个数字能排成的最小数字321323。
 * 
 * @author hao
 *
 */
public class Offer045 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static String PrintMinNumber(int [] numbers) {
		return Solution1(numbers);
    }

	/**
	 * 重新定义大于和小于的比较规则
	 * @param numbers
	 * @return
	 */
	private static String Solution1(int[] numbers) {
		if(numbers==null || numbers.length<=0){
            return "";
        }
        ArrayList<String> list = new ArrayList<String>();
        for(int num : numbers){
            list.add(String.valueOf(num));
        }
        Collections.sort(list,new Comparator<String>(){
             @Override
            public int compare(String s1,String s2){
                String a = s1+s2;
                String b = s2+s1;
                return a.compareTo(b);
            }
        });
        StringBuffer sb = new StringBuffer();
        for(String str:list){
            sb.append(str);
        }
        return sb.toString();

	}

	private static void test1() {
		int array[] = {3,32,321};
		String minNum = PrintMinNumber(array);
		System.out.println(minNum);
	}

	private static void test2() {

	}
	private static void test3() {

	}
}