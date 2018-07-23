package P31_P50;

/**
 * @author zhaotian
 * @date 2018/7/23 16:41
 */
//给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
//
//        示例 1:
//
//        输入: [1,2,0]
//        输出: 3
//
//        示例 2:
//
//        输入: [3,4,-1,1]
//        输出: 2
//
//        示例 3:
//
//        输入: [7,8,9,11,12]
//        输出: 1
//
//        说明:
//
//        你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

public class P41 {
    public static void main(String[] args) {
        int nums[]={3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        if (nums == null||nums.length==0) {
            return 1;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]<nums.length && nums[i]>0 && nums[nums[i]-1]!=nums[i]) {//(0~length-1 对应着1~n)
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
                i--;
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
