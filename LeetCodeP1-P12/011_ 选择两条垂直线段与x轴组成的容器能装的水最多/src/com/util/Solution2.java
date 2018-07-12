package com.util;
 

public class Solution2 {
	
	 public int maxArea(int[] height) {
		 int l=0,r=height.length-1,maxResult=0;
		 while(l<r){
			 maxResult=Math.max(maxResult,Math.min(height[l],height[r])*(r-l));
			 if(height[l]<height[r]){
				 l++;
			 }
			 else
				 r--;
		 }
		 return maxResult;
	 }
}
 