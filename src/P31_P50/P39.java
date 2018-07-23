package P31_P50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/7/22 12:33
 */
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。
//
//        示例 1:
//
//        输入: candidates = [2,3,6,7], target = 7,
//        所求解集为:
//        [
//        [7],
//        [2,2,3]
//        ]
//
//        示例 2:
//
//        输入: candidates = [2,3,5], target = 8,
//        所求解集为:
//        [
//        [2,2,2,2],
//        [2,3,3],
//        [3,5]
//        ]
//

public class P39 {
    public static void main(String[] args) {
        int[] canidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(canidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res=new ArrayList<List<Integer>>();
      Arrays.sort(candidates);
      IsBackTracking(res,new ArrayList<Integer>(),candidates,0,target);
      return res;

    };

    /**
     *
     * @param res 所有List结果集
     * @param result 某一个符合条件的List
     * @param nums 整数数组（已经排序好的）
     * @param start 起始下标
     * @param remain target-（已添加数之和） 之差
     * @return
     */
    public static boolean IsBackTracking(List<List<Integer>> res,List<Integer> result,int[] nums,int start,int remain){
        if (remain<0){
            return false;
        }
        else if(remain==0){
            //条件符合
            res.add(new ArrayList<>(result));
            return false;//在这之后无满足条件
        }
        else {//目前所添加数之和小于target
            for (int i = start; i <nums.length ; i++) {
                boolean backtrack;
                result.add(nums[i]);//
                backtrack=IsBackTracking(res,result,nums,i,remain-nums[i]);
                result.remove(result.size()-1);//回溯时要移除最后一个元素
                if(backtrack==false){//跳出本次循环
                    break;
                }
            }
            return true;
        }
    }
}

