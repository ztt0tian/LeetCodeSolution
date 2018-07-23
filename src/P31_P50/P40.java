package P31_P50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/7/23 10:56
 */
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用一次。
//
//        说明：
//
//        所有数字（包括目标数）都是正整数。
//        解集不能包含重复的组合。
//示例 1:
//
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        所求解集为:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]

public class P40 {
    public static void main(String[] args) {
//        int[] canidates = {10, 1, 2, 7, 6, 1, 5};
//        int target = 8;
        int[] canidates = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(combinationSum2(canidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper2(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private static void helper2(int[] candidates, int target, int start, ArrayList<Integer> integers, List<List<Integer>> res) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(integers));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                integers.add(candidates[i]);
                helper2(candidates, target - candidates[i], i+1, integers, res);
                integers.remove(integers.size() - 1);
            }
        }
    }
}
