/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P51_P70;

/**
 * @author zhaotian
 * @date 2018/9/21 16:36
 */
//动态规划思想
public class P55_DP {
    public static void main(String[] args) {
//        int nums[] = {4,2,1,1,4};
        int nums[] = {2,1,0,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];//dp[i]表示走到i位置剩余的最大步数，由dp[i-1]和nums[i-1]决定
        dp[0] = 0;
        for (int i = 1; i <nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return dp[nums.length - 1] >=0;
    }
}
