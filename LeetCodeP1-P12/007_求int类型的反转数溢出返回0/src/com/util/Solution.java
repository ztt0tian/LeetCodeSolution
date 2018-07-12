package com.util;
/**
 * 123 return 321
 * -123 return -321
 * @author asus-wh
 *
 */

public class Solution {
	 public int reverse(int x) {
		 int flag=1;
		 long result=0;
		if(x==0){
			return 0;
		}
		if(x<0){
			flag=-1;
		}
		 
		x=Math.abs(x);
		while(x/10!=0){
			result=(result+x%10)*10;
			x=x/10;
		}
		result=flag*(result+x%10);
		//System.out.println(flag);
		if(result<Integer.MIN_VALUE){
			return 0;
		}
		if(result>Integer.MAX_VALUE){
			return 0;
		}
		return (int) result;
	        
	    }
}
 