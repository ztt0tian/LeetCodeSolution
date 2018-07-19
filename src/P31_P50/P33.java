package P31_P50;


import java.util.Stack;

/**
 * @author zhaotian
 * @date 2018/7/19 13:48
 */
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//        搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//        你可以假设数组中不存在重复的元素。
//
//        你的算法时间复杂度必须是 O(log n) 级别。
//
//        示例 1:
//
//        输入: nums = [4,5,6,7,0,1,2], target = 0
//        输出: 4
//
//        示例 2:
//
//        输入: nums = [4,5,6,7,0,1,2], target = 3
//        输出: -1

//实质 二分查找的变体
//    假设数组是A，每次左边缘为l，右边缘为r，还有中间位置是m。在每次迭代中，分三种情况：
//            （1）如果target==A[m]，那么m就是我们要的结果，直接返回；
//            （2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），
//             那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
//            （3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
public class P33 {
    public static void main(String[] args) {
        int nums[] = {3,1};
        int target = 1;
        System.out.println(search(nums, target));

    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[right]) {//左边升序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else left = mid + 1;
            } else {//右边升序
                if (target <= nums[right] && target > nums[mid]) {
                    left=mid+1;
                }
                else right=mid-1;
            }

        }
        return -1;
    }
}
