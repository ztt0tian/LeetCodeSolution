package com.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution2 {
	public int lengthOfLongestSubstring(String s) {
		int length=s.length();
		Set<Character> set=new HashSet<>();
		int result=0,i=0,j=0;
		while(i<length&&j<length){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j));
				j++;
				result=Math.max(result, j-i);
			}
			else{
				set.remove(s.charAt(i));
				i++;
			}
			Iterator iterator=set.iterator();
			while(iterator.hasNext())
			{
				System.out.print(iterator.next());
			}
			System.out.println("\n");
		}
		return result;
	}
}
