package P31_P50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/7/23 15:43
 */
public class P39_new {
    public static void main(String[] args) {
        int[] canidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(canidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res=new ArrayList<>();
        if (candidates==null||candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<Integer>(),res);
        return res;
    }

    private static void helper(int[] candidates, int target, int start, ArrayList<Integer> integers, List<List<Integer>> res) {
        if (target <0) {
            return;
        }
        else if(target==0){
            res.add(new ArrayList<>(integers));
            return;
        }
        else {
            for (int i = start; i <candidates.length ; i++) {
                if(i>0&&candidates[i]==candidates[i-1]){
                    continue;
                }
                integers.add(candidates[i]);
                helper(candidates,target-candidates[i],i,integers,res);
                integers.remove(integers.size()-1);
            }
        }
    }
}
