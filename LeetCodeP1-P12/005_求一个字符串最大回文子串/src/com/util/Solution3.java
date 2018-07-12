package com.util;

public class Solution3 {
	public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        char[] chars = s.toCharArray();
        char[] p = new char[2 * chars.length + 1];
        int[] radiuses = new int[p.length];
        int maxRight = 0, pos = 0, maxLenPos = 0;
        p[p.length - 1] = '#';
        for (int i = 0; i < chars.length; i++) {
            p[i * 2] = '#';
            p[i * 2 + 1] = chars[i];
           
        }
        System.out.println("i"+" "+"中点"+" "+"右边界"+" "+"回文半径");
        for (int i = 0; i < p.length; ++i) {
        	
            if (maxRight > i) radiuses[i] = Math.min(radiuses[2*pos - i], maxRight - i + 1);
            else radiuses[i] = 1;
            while(i - radiuses[i] >= 0 && i + radiuses[i] < p.length && p[i - radiuses[i]] == p[i + radiuses[i]]) {
                radiuses[i]++;
            }
            radiuses[i]--;
            if (i + radiuses[i] - 1 > maxRight) {
                maxRight = i + radiuses[i] - 1;
                pos = i;
            }
            if (radiuses[i] > radiuses[maxLenPos]) maxLenPos = i;
            System.out.println(i+"  "+pos+"    "+maxRight+"      "+radiuses[i]);
        }
        System.out.println(radiuses[0]);
        return String.valueOf(chars, (maxLenPos - radiuses[maxLenPos] + 1) / 2, radiuses[maxLenPos]);
    }
}
