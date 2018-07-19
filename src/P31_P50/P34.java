package P31_P50;

/**
 * @author zhaotian
 * @date 2018/7/19 15:03
 */
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        你的算法时间复杂度必须是 O(log n) 级别。
//
//        如果数组中不存在目标值，返回 [-1, -1]。
//
//        示例 1:
//
//        输入: nums = [5,7,7,8,8,10], target = 8
//        输出: [3,4]
//
//        示例 2:
//
//        输入: nums = [5,7,7,8,8,10], target = 6
//        输出: [-1,-1]
//

public class P34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        for (int x:searchRange(nums,target)
             ) {
            System.out.println(x);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int []res=new int[]{-1,-1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left=0;
        int right=nums.length-1;
        int start=-1,end=-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                start=end=mid;
                while (start>=left&&nums[start]==target){
                    start--;//往左找第一个
                }
                while (end<=right&&nums[end]==target){
                    end++;//往右找最后一个
                }
                res[0]=start+1;
                res[1]=end-1;
                break;
            }
            else if (nums[mid]<target){
                left=mid+1;
            }
            else {
                right=mid-1;
            }

        }
        return res;
    }
}
