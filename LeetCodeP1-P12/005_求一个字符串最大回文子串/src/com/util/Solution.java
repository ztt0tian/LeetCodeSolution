package com.util;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public String longestPalindrome(String s) {
		int length=s.length();
		int i=0,j=0;
		 int rlength=0;
		 String result="";
		 int start=0;//最长回文起始位置
		 if(length==1){
			 return s;
		 }
		 for(i=0;i<length;i++){//起始位
			  
			
			 for(j=i+1;j<length;j++){//终止位
				 //判断是否为回文
				 int temp1,temp2;
				 for(temp1=i,temp2=j;temp1<length&&temp2>=0;temp1++,temp2--){
					 
					 if(s.charAt(temp1)!=s.charAt(temp2))
						 break;
				 }
				// System.out.println("j-i="+(j-i)+(temp1>=temp2&&j-i>rlength));
				 if(temp1>=temp2&&j-i>=rlength){
					 //System.out.println(j+"=="+i);i
					 rlength=j-i+1;
					 start=i;
				 }
			 }
		 }
		 
		 if(rlength>0){
			 //System.out.println(rlength);
			 return s.substring(start,start+rlength);
		 }
		return null;   
    }
}
