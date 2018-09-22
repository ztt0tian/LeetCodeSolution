/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P51_P70;

/**
 * @author zhaotian
 * @date 2018/9/21 16:05
 */
//初次想到使用递归来解决 但是复杂度太高
public class P55_timeout {
    public static void main(String[] args) {
        int nums[] = {4,2,1,1,4};
//        int nums[] = {2,1,0,0};
        System.out.println(canJump(nums));

    }
    private static boolean canJump(int[] nums) {
        int cur_dis = nums.length-1;
        int start_index = 0;
        return canJump_helper(nums,start_index, cur_dis);
    }

    private static boolean canJump_helper(int[] nums, int start_index, int cur_dis) {
        if (nums[start_index]>=cur_dis) {
            return true;
        }
        else {
            for (int i = nums[start_index]; i>=1 ; i--) {
                cur_dis = cur_dis - i;
                start_index = start_index + i;
                if (start_index >=nums.length) {
                    continue;
                }
                if(canJump_helper(nums,start_index,cur_dis)){
                    return true;
                }
                else {
                    //回退
                    start_index=start_index-i;
                    cur_dis = cur_dis + i;
                }
            }
            return false;
        }
    }
}
