/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn
 */

package P31_P50;

import java.util.*;

/**
 * @author zhaotian
 * @date 2018/9/9 14:03
 */
//一种新思路
public class P49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map_base = new HashMap<>();
        for (String s : strs) {
            boolean flag = true;
            char s_array[] = s.toCharArray();
            Arrays.sort(s_array);
            if (map_base.get(new String(s_array))!=null){
                map_base.get(new String(s_array)).add(s);
                flag = false;
            }
            if (flag) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map_base.put(new String(s_array), list);
                res.add(list);
            }
        }
        return res;
    }
}
