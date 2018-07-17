package P12_P30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/6/27 17:06
 * 来源于discuss
 */
public class P18 {
    public static void main(String[] args) {
        int nums[]={-1,0,1,2,-1,-4};
        List<List<Integer>> result=fourSum(nums,-1);
        for(List<Integer> unit:result){
            System.out.println(unit.toString());
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);//先排序
        int len=nums.length;
        if(nums==null||len<4){
            return res;
        }
        int max=nums[len-1];
        int min=nums[0];
        if(4*min>target||4*max<target){//特殊情况
            return res;
        }
        int current;
        for(int i=0;i<nums.length;i++){
            current=nums[i];//当前值
            if(i>0 && nums[i]==nums[i-1]){//避免产出重复
                continue;
            }
            if(current+3*max<target){//当前值太小了
                continue;
            }
            if(4*current>target){
                break;//当前值太大了，之后不能有条件满足
            }
            if(4*current==target){//可能存在的一种边界 即接下来的两个数均为current2
                if(i+3<len&&nums[i+3]==current){
                    res.add(Arrays.asList(current,current,current,current));
                    break;
                }
            }
            //找满足三数之和等于target-current的list
            threeSum(nums,i+1,len-1,target-current,res,current);
        }
        return res;
    }
    private static void threeSum(int[] nums, int low, int high, int target, List<List<Integer>> res, int current) {
        if(low+1>=high){//没有足够多的数可以选了
            return;
        }
        int max=nums[high];
        int min=nums[low];
        if(min*3>target||max*3<target){//特殊情况，所有数偏小或偏大
            return;
        }
        int current2;
        for(int j=low;j<high-1;j++){
            current2=nums[j];
            if(j>low && nums[j]==nums[j-1] ){//避免重复
                continue;
            }
            if(current2+2*max<target){//当前值太小
                continue;
            }
            if(3*current2>target){//当前值太大
                break;
            }
            if(3*current2==target){//可能存在的一种边界 即接下来的两个数均为current2
                if(j+1<high&&nums[j+2]==current2){
                    res.add(Arrays.asList(current,current2,current2,current2));
                    break;
                }
            }
            //找满足两数之和等于target-current2的list
            twoSum(nums,j+1,high,target-current2,res,current,current2);
        }
    }

    private static void twoSum(int[] nums, int low, int high, int target, List<List<Integer>> res,int current, int current2) {
        if(low>=high){//没有足够多的数可以选了
            return;
        }
        int max=nums[high];
        int min=nums[low];
        if(2*min>target||2*max<target){
            return;
        }
        int left=low,right=high,sum,temp;
        while (left<right){
            sum=nums[left]+nums[right];
            if(sum==target){
                res.add(Arrays.asList(current,current2,nums[left],nums[right]));
                temp=nums[left];
                while (++left<right&&nums[left]==temp);//循环到第一个不是当前值的左数
                temp=nums[right];
                while (--right>left&&nums[right]==temp);//循环到第一个不是当前值的右数
            }
            if(sum<target){//偏小 左值右移
                left++;
            }
            if(sum>target){//偏大 右值左移
                right--;
            }
        }
    }
}
