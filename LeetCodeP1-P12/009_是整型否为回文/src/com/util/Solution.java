package com.util;
 

public class Solution {
public boolean isPalindrome(int x) {
        String string=String.valueOf(x);
        int n=string.length();
        if(n==1){
        	return true;
        }
        int i,j;
        for(i=0,j=n-1;i<=j;i++,j--){
        	if(string.charAt(i)!=string.charAt(j)){
        		return false;
        	}
        }
		return true;
    }
}
 