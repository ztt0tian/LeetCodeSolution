package com.util;

public class Solution2 {
	int begin,maxlen;
	public String longestPalindrome(String s){
		int n=s.length();
		for(int i=0;i<n;i++){
			longestPalindromeUtil(s,i,i);//假设最长回文长度为奇数
			longestPalindromeUtil(s,i,i+1);//假设最长回文长度为偶数数
		}
		return s.substring(begin, begin+maxlen);
		
	}
	private void longestPalindromeUtil(String s, int i, int j) {
		// TODO Auto-generated method stub
		while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
			i--;
			j++;
		}
		if(j-i-1>maxlen){
			begin=i+1;
			maxlen=j-i-1;
		}
		
	}
}