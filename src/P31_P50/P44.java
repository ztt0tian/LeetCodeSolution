/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P31_P50;

/**
 * @author zhaotian
 * @date 2018/9/3 10:23
 */
//采用动态规划来解
/**
 * 这个方法用的是动态规划的方法，即针对？ * 和普通字符建立一个矩阵，表示其转移
 * 初始0，0位置匹配
 * 对于每一个位置：
 * 如果是Pattern为*，那么当前位置可以匹配到的条件是，只要他的左边 上边 或者左上 任意有一个可以到就可以了
 * 如果是？或相等，那么条件就是左上可以访问到
 * 如果不是，那么久证明不可以访问到了
 *
 * 估计有比我更好的方法存在的。
 * */
public class P44 {
    public static void main(String[] args) {
        String s = "babaabbbbbaaaaabbaababbaaaaaaabbaabaabbbabbaabbbbb";
        String p = "*ba**bbbb";
        System.out.println(isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {
        char S[] = s.toCharArray();
        char P[] = p.toCharArray();
        int s_length = S.length, p_length = P.length;
        boolean flag[][] = new boolean[p_length+1][s_length+1];
        flag[0][0]=true;//"" ""
        int start=0;
        for (int i = 1; i <=p_length; i++) {
            if (P[i-1] == '*') {
                flag[i][0]=flag[i-1][0];
                for (int j = 1; j <=s_length; j++) {
                    flag[i][j]=flag[i-1][j-1]||flag[i][j-1]||flag[i-1][j];
                }
            }
            else {
                start++;
                for (int j = start; j <=s_length ; j++) {
                    if (P[i-1]=='?'||S[j-1]==P[i-1]) {
                        if (flag[i-1][j-1]) {
                            flag[i][j]=true;
                        }
                    }
                }
            }
        }
        return flag[p_length][s_length];
    }

}
