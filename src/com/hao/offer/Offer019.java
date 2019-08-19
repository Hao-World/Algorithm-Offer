package com.hao.offer;

/**
 * 【面试题19】 【正则表达式匹配】
 * 
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。 
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。 
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * 
 * @author hao
 *
 */
public class Offer019 {
	
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	public static boolean match(char[] str, char[] pattern) {
		return Solution1(str, pattern);
	}
	
	/**
	 * 方法1
	 * @param str 字符串
	 * @param pattern 模式串
	 * @return
	 */
	private static boolean Solution1(char[] str, char[] pattern) {
		if(str == null || pattern == null) {
			return false;
		}
		
		return matchCore(str,0,pattern, 0);
	}

	/**
	 * 字符串匹配的核心算法：
	 * 
	 * @param str 字符串
	 * @param i  字符串当前索引
	 * @param pattern  模式串
	 * @param j  模式串当前索引
	 * @return
	 */
	private static boolean matchCore(char[] str, int i, char[] pattern, int j) {
		if(i==str.length && j==pattern.length) {
			return true;
		}
		if(i<str.length && j==pattern.length) {
			return false;
		}	
		if(j+1<pattern.length && pattern[j+1] == '*') {
			if((i<str.length && (str[i] == pattern[j]) || pattern[j]=='.')) {
				//这里需要判断字符串和匹配串当前字符是否相等， 如果模式串当前字符为'.'，也为相等
				return matchCore(str,i+1,pattern,j+2)   
					|| matchCore(str, i+1, pattern, j) 
					|| matchCore(str, i, pattern, j+2);  // 如果模式串是 ba*ac这种情况 a*是可以直接跳过的
			}else {
				return matchCore(str,i,pattern,j+2); // 当前字符不相等，可以直接跳过a*
			}
		}
		
		//这里要放在后面
		if(i<str.length && (str[i]==pattern[j] || pattern[j]=='.')) {
			return matchCore(str, i+1, pattern, j+1);
		}
		
		return false;
	}

	/**
	 * 此测试程序参考自 剑指Offer一书中的源码[https://github.com/zhedahht/CodingInterviewChinese2]
	 * @param testName
	 * @param str
	 * @param pattern
	 * @param expected
	 */
	private static void test(String testName, char[] str, char[] pattern, boolean expected) {
        System.out.print(testName + ":");
        if (match(str, pattern) == expected)
            System.out.println("passed!");
        else
            System.out.println("failed!");
    }
	
	/**
	 * 功能测试
	 */
	private static void test1() {
		char[] str1 = "aaa".toCharArray();
		char[] str2 = "aaa".toCharArray();
		char[] pattern1 = "a*.b*b*aa".toCharArray();
		char[] pattern2 ="ab*ac*a".toCharArray();
		test("aaa,a*.b*b*aa --->", str1, pattern1, true);
		test("aaa,ab*ac*a--->", str2, pattern2, true);
		char[] str3 = {'a'};
		char[] pattern3 = {'.','*'};
		test("a, .* -->", str3, pattern3, true);
		
	}
	
	/**
	 * 特殊测试
	 */
	private static void test2() {
		char[]  str = {};
		char[] pattern = null;
		test("{},null --->", str, pattern, false);
	}
}
