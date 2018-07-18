package P31_P50;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/7/17 17:11
 */
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//        必须原地修改，只允许使用额外常数空间。
//
//        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1
//有如下的一个数组
//
//        1　　2　　7　　4　　3　　1
//
//        下一个排列为：
//
//        1　　3　　1　　2　　4　　7
//
//        那么是如何得到的呢，我们通过观察原数组可以发现，如果从末尾往前看，数字逐渐变大，
//        到了2时才减小的，然后我们再从后往前找第一个比2大的数字，是3，那么我们交换2和3，
//        再把此时3后面的所有数字转置一下即可，步骤如下：
//
//        1　　2　　7　　4　　3　　1
//
//        1　　2　　7　　4　　3　　1
//
//        1　　3　　7　　4　　2　　1
//
//        1　　3　　1　　2　　4　　7
public class P31 {
    public static void main(String[] args) {
        int nums[]={1,5,1};
        nextPermutation(nums);
        for (int x: nums
             ) {
            System.out.println(x);
        }

    }
    public static void nextPermutation(int[] nums) {
        //从 末尾开始 找到第一个开始减小的那个数
        int right=nums.length-1;//最右那个数的下标
        while(right>=1&&nums[right]<=nums[right-1]){
            right--;
        }
        if(right==0){
            //从右至左一直递增 则求最小序列
            reverse(nums,0,nums.length-1);
        }
        //中途有减小
        else {
            int min=nums[right-1];
            //从右往左找到第一个比min大的数 并交换
            int i=nums.length-1;
            while (nums[i]<=min){
                i--;
            }
            int temp=nums[right-1];
            nums[right-1]=nums[i];
            nums[i]=temp;
            //把righ之后的数逆置
            reverse(nums,right,nums.length-1);

        }
    }
    public static void reverse(int nums[],int i_left,int i_right){
        while (i_left<i_right){
            int temp=nums[i_right];
            nums[i_right--]=nums[i_left];
            nums[i_left++]=temp;
        }
    }
}
