/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P31_P50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhaotian
 * @date 2018/9/9 12:13
 */
//某些用例超时
public class P49_time_too_long {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> u_res = new ArrayList<>();
        int count = 0;
        int[] flag = new int[strs.length];
        int start = 0;
        while (count<strs.length) {
            List<String> str_pailie = permuteUnique(strs[start]);
            for (int i = start; i < strs.length; i++) {
                if (flag[i]==0&&str_pailie.contains(strs[i])){
                    u_res.add(strs[i]);
                    flag[i] = 1;
                    count++;
                }
                if (i == strs.length-1&&u_res.size()!=0) {
                    res.add(new ArrayList<String>(u_res));
                    u_res.clear();
                }
            }
            start = firstNoZero(flag);
        }
        return res;
    }

    public static int firstNoZero(int[] flag) {
        for (int i = 0; i <flag.length ; i++) {
            if (flag[i]==0) {
                return i;
            }
        }
        return -1;
    }

    public static List<String> permuteUnique(String s) {
        List<String> sList = new ArrayList<>();
        for (int i = 0; i <s.length() ; i++) {
            sList.add(String.valueOf(s.charAt(i)));
        }
        List<String> res = new ArrayList<>();
        permuteUnique_util(sList, res, 0);
        return res;
    }
    public static void permuteUnique_util(List<String> sList, List<String> res, int start) {
        if (start==sList.size()){
            String s="";
            for (String x:sList
                 ) {
                s += x;
            }
            res.add(s);
            return;
        }
        Set<String> appeared = new HashSet<>();
        for (int i = start; i < sList.size(); i++) {
            if (appeared.add(sList.get(i))) {
                swap_list(sList, start, i);//固定当前位置，进行下一位全排列
                permuteUnique_util(sList, res,start + 1);
                swap_list(sList, start, i);//还原
            }
        }
    }
    public static void swap_list(List<String> sList, int s, int i) {
        String t = sList.get(s);
        sList.set(s, sList.get(i));
        sList.set(i, t);
    }
}
