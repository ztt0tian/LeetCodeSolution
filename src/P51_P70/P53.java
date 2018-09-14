/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn
 */

package P51_P70;

/**
 * @author zhaotian
 * @date 2018/9/14 16:26
 */
public class P53 {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curSum + nums[i] > nums[i]) {
                curSum = curSum + nums[i];
            } else {
                curSum = nums[i];
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
