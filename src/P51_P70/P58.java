/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P51_P70;

/**
 * @author zhaotian
 * @date 2018/9/26 13:17
 */
public class P58 {
    public static void main(String[] args) {
        //String s = "a ";
        String s = "a dsad";
        System.out.println(s.substring(2,6));
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        int i = 0;
        int start = 0;
        int end = 0;
        while (i<s.length()){
            if (i+1<s.length()&&s.charAt(i) == ' '&&s.charAt(i+1)!=' ') {
                start = i+1;
            }
            if (s.charAt(i) != ' ') {
                end = i+1;
            }
            i++;
        }
        return end-start;
    }
}
