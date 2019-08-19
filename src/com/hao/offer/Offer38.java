package com.hao.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 【面试题38】 【字符串的排列】
 *  输入一个字符串，打印出该字符串中字符的所有排列。
 *  例如，输入字符串abc,则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、 bac、bca、cab和cba。
 * 
 * @author hao
 *
 */
public class Offer38 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public ArrayList<String> Permutation(String str) {
		return Solution1(str);
	}

	private static ArrayList<String> Solution1(String str) {
		ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0){
            return list;
        }
        permutationCore(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;
	}
	
	 private static void permutationCore(char[] array,int index,ArrayList<String> list){
	        if(index == array.length-1){
	            if(!list.contains(String.valueOf(array))){
	                list.add(String.valueOf(array));
	            }
	        }else{
	            for(int i=index;i<array.length;i++){
	                char tmp = array[index];
	                array[index] = array[i];
	                array[i] = tmp;
	                permutationCore(array,index+1,list);
	                array[i]=array[index];
	                array[index] = tmp;   
	            }
	        }
	    }

	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}