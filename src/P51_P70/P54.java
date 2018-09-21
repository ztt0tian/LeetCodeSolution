/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P51_P70;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/9/14 18:52
 */
public class P54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
//                {7, 8, 9},
//                {10,11,12}
        };
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length<= 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        spiralOrder_helper(matrix, 0, 0, row - 1, col - 1, res);
        return res;
    }

    private static void spiralOrder_helper(int[][] matrix, int r1, int c1, int r2, int c2, List<Integer> res) {
        if(r1>r2||c1>c2){
            return;//添加完了
        }
        if (r1 == r2&&c1==c2) {
            res.add(matrix[r1][c1]);//方阵只剩最后一个数
            return;
        }
        for (int i = c1; i <=c2; i++) {
            res.add(matrix[r1][i]);//第一横行
        }
        for (int i =r1+1; i <=r2 ; i++) {
            res.add(matrix[i][c2]);//第一竖列
        }
        if(r2-r1>0) {
            for (int i = c2 - 1; i >= c1; i--) {
                res.add(matrix[r2][i]);//第二横行
            }
        }
        if(c2-c1>0) {
            for (int i = r2 - 1; i > r1; i--) {
                res.add(matrix[i][c1]);//第二竖列
            }
        }
        spiralOrder_helper(matrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, res);
    }
}
