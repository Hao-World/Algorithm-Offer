package com.hao.offer;

/**
 * 【面试题5】
 * 【替换空格】
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入“We are happy.”，则输出“We%20are%20happy.”。
 * @author hao
 *
 */
public class Offer005 {
	public static void main(String[] args) {
		StringBuffer str =new StringBuffer("We are no happy");
		System.out.println(Offer005.replaceSpace(str)); 
		
	}
	
	public static String replaceSpace(StringBuffer str) {
		return Solution2(str);
	}

	private static String Solution1(StringBuffer str) {
		if(str==null) {
			throw new IllegalArgumentException("参数非法!");
		}
		int length = str.length();
		int indexOfOrig = length-1;//旧的索引位置指向 旧的字符串末尾
		//获取替换空格后的总长度
		
		for(int i= 0;i< str.length();i++) {
			if(str.charAt(i)==' ') {
				length+=2; // 因为要把空格替换成"%20",每次出现空格就要将长度增加2
			}
		}
		
		str.setLength(length);//设置新的str长度
		int indexOfNew = length-1;//新的索引位置指向 新的字符串末尾
		
		while(indexOfNew>indexOfOrig) {
			if(str.charAt(indexOfOrig)!=' ') {
				str.setCharAt(indexOfNew--, str.charAt(indexOfOrig));
			}else {
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--, '2');
				str.setCharAt(indexOfNew--, '%');
			}
			indexOfOrig--;
		}	
		return str.toString();
	}
	
	private static String Solution2(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");
	}
	
}
