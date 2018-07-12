package com.util;

public class Solution {
	public String convert(String s, int numRows) {
		if(s==""||numRows==1){
			return s;
		}
		String rString="";
		int l=s.length();
		int numCols=(int) Math.ceil((double)l/(double)(2*numRows-2));
		int jiange=2*numRows-2;
		while(numCols*(2*numRows-2)>l){
		s=s+"#";
		l++;
		} 
		//first row
		for(int col=0;col<numCols;col++){
		rString=rString+s.charAt(0+col*jiange);
		}
		//form seconde to numRows-1 row
		for(int row=2;row<=numRows-1;row++){
		for(int col=0;col<numCols;col++){
			rString=rString+s.charAt(row-1+col*jiange)+s.charAt(2*numRows-row-1+col*jiange);
			}
		}
		//the nRows row
		for(int col=0;col<numCols;col++){
			rString=rString+s.charAt(numRows-1+col*jiange);
			}
		System.out.println("one to nRows row:"+rString);
		return rString.replace("#", "");
        
    }
}
