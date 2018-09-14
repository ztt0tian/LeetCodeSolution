/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P51_P70;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaotian
 * @date 2018/9/13 16:56
 */
public class P52 {
    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }
    public static int totalNQueens(int n) {
        Set<Integer> col_set = new HashSet<>();
        Set<Integer> zuoshang_set = new HashSet<>();
        Set<Integer> youshang_set = new HashSet<>();
        return totalNQueens_helper(0, n, col_set, zuoshang_set, youshang_set, 0);
    }

    private static int totalNQueens_helper(int row, int n, Set<Integer> col_set, Set<Integer> zuoshang_set, Set<Integer> youshang_set, int count) {
        if (row == n) {
            count++;
        }
        for (int i = 0; i <n ; i++) {
            if (col_set.contains(i) || zuoshang_set.contains(row - i) || youshang_set.contains(row + i)) {//列 左上 右上
                continue;
            }
            col_set.add(i);//加入当前列
            zuoshang_set.add(row - i);//加入左上
            youshang_set.add(row + i);//加入右上
            count=totalNQueens_helper(row + 1, n, col_set, zuoshang_set, youshang_set,count);
            youshang_set.remove(row + i);//还原
            zuoshang_set.remove(row - i);//还原
            col_set.remove(i);//还原
        }
        return count;
    }

}
