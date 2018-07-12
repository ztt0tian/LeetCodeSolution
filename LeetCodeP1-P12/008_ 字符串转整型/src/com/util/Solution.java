package com.util;
 

public class Solution {
	public int myAtoi(String str) {
		int flag;
		if(str==null||str.length()==0||str.startsWith("-+")||str.startsWith("+-")){
			return 0;
		}
		str=str.trim();
		if(!str.startsWith("-")&&!str.startsWith("+")){
			str="+"+str;
		}
		//System.out.println(str);
		int n=str.length();
		int digit = 0;
		long result=0;
		flag=str.charAt(0)=='-'?-1:1;
		for(int i=1;i<n;i++){
			if(!('0'<=str.charAt(i)&&str.charAt(i)<='9')){
                break;
            }
			if('0'<=str.charAt(i)&&str.charAt(i)<='9'){
				 digit=Integer.parseInt(String.valueOf(str.charAt(i)));	
				// System.out.println(digit);
			}
			if(Integer.MAX_VALUE/10<result||Integer.MAX_VALUE/10==result && Integer.MAX_VALUE%10<digit )
            {
                return flag==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
			result=result*10+digit;
		}
		 
		//System.out.println(flag);
		return (int) (result*flag);
        
    }
}
 