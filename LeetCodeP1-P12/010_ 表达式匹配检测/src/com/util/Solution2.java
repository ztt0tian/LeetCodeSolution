package com.util;

public class Solution2 {
	public boolean isMatch(String s, String p) {  
	    if(s.length()==0 && p.length()==0)  
	        return true;  
	    if(p.length()==0)  
	        return false;  
	    boolean[][] res = new boolean[s.length()+1][p.length()+1];  
	    res[0][0] = true;  
	    for(int j=0;j<p.length();j++)  
	    {  
	        if(p.charAt(j)=='*')  
	        {  
	            if(j>0 && res[0][j-1]) res[0][j+1]=true;  
	            if(j<1) continue;  
	            if(p.charAt(j-1)!='.')  
	            {  
	                for(int i=0;i<s.length();i++)  
	                {  
	                    if(res[i+1][j] || j>0&&res[i+1][j-1]   
	                    || i>0 && j>0 && res[i][j+1]&&s.charAt(i)==s.charAt(i-1)&&s.charAt(i-1)==p.charAt(j-1))  
	                        res[i+1][j+1] = true;  
	                }  
	            }  
	            else  
	            {  
	                int i=0;  
	                while(j>0 && i<s.length() && !res[i+1][j-1] && !res[i+1][j])  
	                    i++;  
	                for(;i<s.length();i++)  
	                {  
	                    res[i+1][j+1] = true;  
	                }  
	            }  
	        }  
	        else  
	        {  
	            for(int i=0;i<s.length();i++)  
	            {  
	                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')  
	                    res[i+1][j+1] = res[i][j];  
	            }  
	        }  
	    }  
	    return res[s.length()][p.length()];  
	}  
	
}
 