package com.hao.offer;

/**
 * 
 * 【面试题10】
 * 【青蛙跳阶问题】
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author hao
 *
 */
public class Offer10_2 {
	public static void main(String[] args) {
		
	}
	
    public static int JumpFloor(int target) {
    	return Solution1(target);
    }

    /**
     * 解法一 斐波那契数列 非递归
     * @param target
     * @return
     */
	private static int Solution1(int target) {
		if(target == 1) {
			return 1;
		}
		if(target ==2) {
			return 2;
		}
		int fm2 = 1;
		int fm1 = 2;
		int fN = 0;
		for(int i=3;i<=target;i++) {
			fN =fm2+fm1;
			fm2 = fm1;
			fm1 = fN;
		}
		return fN;
	}

}
