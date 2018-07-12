package com.util;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int length=s.length();
		int result=0;
		int begin=0;
		for(int i=0;i<length;i++){
			for(int j=i+1;j<=length;j++){
				if(norepeat(s, i, j)){
					if(j-i>result){
						begin=i;
					}
					result=Math.max(result, j-i);
					
				}
			}
		}
		System.out.println(s.substring(begin, begin+result));
		return result;    
    }
	public boolean norepeat(String string,int begin,int end){
		Set<Character> set=new HashSet<Character>();
		for(int i=begin;i<end;i++){
			if(set.contains(string.charAt(i))){
				return false;
			}
			set.add(string.charAt(i));
		}
		return true;
	}
}
