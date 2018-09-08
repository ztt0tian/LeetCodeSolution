package P31_P50;

import java.util.*;

public class P47 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 2};
        System.out.println(permuteUnique(array));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> nums_list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums_list.add(nums[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        permute_helper(nums_list, 0, res);
        return res;
    }

    public static void permute_helper(List<Integer> nums_list, int start, List<List<Integer>> res) {
        if (start == nums_list.size()) {//最后一位只有一种可能 不能交换
            res.add(new ArrayList<>(nums_list));//直接add(nums_list) 顺序没有发生改变
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = start; i < nums_list.size(); i++) {
            if (appeared.add(nums_list.get(i))) {
                swap_list(nums_list, start, i);//固定当前位置，进行下一位全排列
                permute_helper(nums_list, start + 1, res);
                swap_list(nums_list, start, i);//还原
            }
        }
    }

    public static void swap_list(List<Integer> list, int s, int i) {
        int t = list.get(s);
        list.set(s, list.get(i));
        list.set(i, t);
    }
}