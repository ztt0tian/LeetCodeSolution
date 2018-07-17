package P12_P30;

import java.util.Arrays;

/**
 * @author zhaotian
 * @date 2018/6/20 10:19
 */
public class P16 {
    public static void main(String[] args) {
        //int nums[]={-1,2,1,-4};
        //int nums[]={0,0,0};
        //int nums[]={1,2,4,8,16,32,64,128};
        //int nums[]={4,0,5,-5,3,3,0,-4,-5};
        //int nums[]={0,-4,1,-5};
        int nums[]={-1,0,1,1,55};
        System.out.println(threeSumClosest(nums,3));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min_closest_dis=Integer.MAX_VALUE;
        int min_closest_sum=Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            int begin=i+1,end=nums.length-1;
            while (begin<end){
                int two_sum=nums[begin]+nums[end];
                if(two_sum==target-nums[i]){
                    return target;
                }
                int three_num_sum=two_sum+nums[i];
                int temp_dis=Math.abs(target-three_num_sum);
                if(temp_dis<min_closest_dis){
                    min_closest_dis=temp_dis;
                    min_closest_sum=three_num_sum;
                }
                if(two_sum<target-nums[i]) begin++;
                else end--;
            }
        }
        return min_closest_sum;
    }

}
