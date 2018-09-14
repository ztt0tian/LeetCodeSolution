/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P51_P70;

import java.util.*;

/**
 * @author zhaotian
 * @date 2018/9/9 16:50
 */
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击(任意两个不再同行同列)。
    //DFS
public class P51 {
//    private static Set<Integer> col_set = new HashSet<>();
//    private static Set<Integer> zuoshang_set = new HashSet<>();
//    private static Set<Integer> youshang_set = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(solveNQueens(9));
    }
    public static List<List<String>> solveNQueens(int n) {
        Set<Integer> col_set = new HashSet<>();
        Set<Integer> zuoshang_set = new HashSet<>();
        Set<Integer> youshang_set = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        solveNQueens_dfs_helper(res, new ArrayList<String>(),0,n,col_set,zuoshang_set,youshang_set);//逐行摆放皇后
        return res;
    }

    public static void solveNQueens_dfs_helper(List<List<String>> res, List<String> list, int row, int n, Set<Integer> col_set, Set<Integer> zuoshang_set, Set<Integer> youshang_set) {
        if (row == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <n ; i++) {
            if (col_set.contains(i) || zuoshang_set.contains(row - i) || youshang_set.contains(row + i)) {//列 左上 右上
                continue;
            }
            char[] newArray = new char[n];
            Arrays.fill(newArray, '.');
            newArray[i] = 'Q';
            list.add(new String(newArray));
            col_set.add(i);//加入当前列
            zuoshang_set.add(row - i);//加入左上
            youshang_set.add(row + i);//加入右上
            solveNQueens_dfs_helper(res, list, row + 1, n, col_set, zuoshang_set, youshang_set);
            list.remove(list.size() - 1);//一定要移除当前添加的一栏
            youshang_set.remove(row + i);//还原
            zuoshang_set.remove(row - i);//还原
            col_set.remove(i);//还原
        }
    }
}
