package com.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public int[] twoSum(int[] nums,int target){
    	List<Integer> result=new  LinkedList<Integer>();
    	int[] Numbers=new int[2];
		for(int i=0;i<nums.length;i++){
			int num1=nums[i];
			for(int j=i+1;j<nums.length;j++){
				if(num1+nums[j]==target){
					result.add(i);
					result.add(j);
				}
			}
		}
		Iterator iterator=result.iterator();
		int pre = 0;
		while(iterator.hasNext()){		
			Numbers[pre]=(int) iterator.next();
			pre++;
		}
		if(Numbers[0]==0&&Numbers[1]==0){
			System.out.println("no two suitable numbers");
			return null;
		}
		else return Numbers;
	}
}
