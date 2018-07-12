package com.util;

public class Solution {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1=nums1.length;
		int l2=nums2.length;
		int l3=l1+l2;
		double result=0.0;
		int[] nums3=new int[l3];
		int i=0,j=0,k=0;
		while(i<l1&&j<l2){
			if(nums1[i]<nums2[j]){
				nums3[k]=nums1[i];
				k++;
				i++;
			}
			else{
				nums3[k]=nums2[j];
				k++;
				j++;
			}
		}
		while(i<l1){
			nums3[k]=nums1[i];
			k++;
			i++;
			
		}
		while(j<l2){
			nums3[k]=nums2[j];
			k++;
			j++;
			
		}
		for(int a=0;a<l3;a++){
			System.out.println(nums3[a]);
		}
		if(l3%2==1){
			result=(double)nums3[l3/2];
		}
		if(l3%2==0){
			result=((double)(nums3[l3/2])+(double)(nums3[l3/2-1]))/(double)2;
		}
		return result;
		 
	    }
}
