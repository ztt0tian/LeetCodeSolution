/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P51_P70;

/**
 * @author zhaotian
 * @date 2018/9/22 11:06
 */
public class P55_GreedyAlgorithm {
    public static void main(String[] args) {
//        int nums[] = {4,2,1,1,4};
        int nums[] = {2,1,0,0};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int dis = nums.length - 1;
        int reach = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (i>reach||reach>dis) break;
            reach = Math.max(i + nums[i],reach);
        }
        return reach >= dis;
    }
}
