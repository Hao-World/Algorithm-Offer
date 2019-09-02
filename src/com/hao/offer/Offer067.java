package com.hao.offer;

/**
 * 【面试题67】 【XX】
 *  模版
 * 
 * @author hao
 *
 */
public class Offer067 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}

	public static int StrToInt(String str) {
		return Solution1(str);
	}

	 static boolean isValid = false;

	private static int Solution1(String str) {
		if(str == null || str.length()<=0)
            return 0;
        char[] chars = str.toCharArray();
        long num=0;  //先用long来存储，以防止越界
        boolean minus=false;
        for(int i=0; i<chars.length; i++){
            if(i==0 && chars[i]=='-'){
                minus=true;
            }else if(i==0 && chars[i]=='+'){
                minus=false;
            }else{
                int a=(int) (chars[i]-'0');
                if(a<0 || a>9){
                    isValid=false;
                    return 0;
                }
                num= (minus==false) ? num*10+a : num*10-a;
                isValid=true;  //不放在最后面是为了防止str=‘+’的情况被判断为true
                if((!minus && num>0x7FFFFFFF)
                   ||(minus && num<0x80000000)){
                    isValid=false;
                    return 0;
                }
            }
        }
        return (int)num;
	}

	private static void test1() {

	}

	private static void test2() {

	}
	private static void test3() {

	}

}