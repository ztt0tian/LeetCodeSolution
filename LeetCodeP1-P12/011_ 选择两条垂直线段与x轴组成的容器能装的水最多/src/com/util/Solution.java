package com.util;
 

public class Solution {
	
	 public int maxArea(int[] height) {
		 int n=height.length;
		 int i,j;
		 int Maxresult=0;
		 int temp;
		 for(i=0;i<n-1;i++){
			 for(j=i+1;j<n;j++){
				 Maxresult=Maxresult<(temp=volume(height, i, j))?temp:Maxresult;
			 }
		 }
		 
		 return Maxresult;      
	    }

	private int volume(int[] height, int i, int j) {
		// TODO Auto-generated method stub	
		return Math.abs(j-i)*Math.min(height[i], height[j]) ;
	}
}
 