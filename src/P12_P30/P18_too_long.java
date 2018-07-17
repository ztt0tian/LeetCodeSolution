package P12_P30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/6/20 17:11
 * 来源于之前的三数之和，可以通过但是执行时间较长
 */
public class P18_too_long {
    public static void main(String[] args) {
        //int nums[]={1, 0, -1, 0, -2, 2};
        // [-1,0,1,2,-1,-4]
        //-1[1,0,-1,0,-2,2]
        int nums[]={-1,0,1,2,-1,-4};
        List<List<Integer>> result=fourSum(nums,-1);
        for(List<Integer> unit:result){
            System.out.println(unit.toString());
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int three_sum = target - nums[i];
                List<List<Integer>> i_result=threeSum(nums,nums[i],i+1,three_sum);
                if(i_result.size()>0){
                    for(int i2=0;i2<i_result.size();i2++){
                        result.add(i_result.get(i2));
                    }
                }
            }
        }
        return result;
    }
    public static List<List<Integer>> threeSum(int[] nums,int current,int begin,int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=begin;i<nums.length-2;i++) {
            if (i==begin||nums[i-1] != nums[i]) {
                int sum = target - nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        result.add(Arrays.asList(current,nums[i], nums[left], nums[right]));
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else right--;
                }
            }
        }
        return result;
    }
}
