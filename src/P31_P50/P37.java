package P31_P50;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhaotian
 * @date 2018/7/20 16:19
 */
public class P37 {
    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.print("{");
            for (int j = 0; j < 9; j++) {
                System.out.print("'" + board[i][j] + "'" + ",");
            }
            System.out.println("}");
        }
    }

    public static void solveSudoku(char[][] board) {
        helper_DFS(board);
    }

    public static boolean helper_DFS(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {//空格需要填入字符1-9
                    for (char c = '1'; c <= '9'; c++) {
                        //board[i][j]=c;
                        if (isValid_still_Sudoku(board, i, j, c)) {
                            //填入对所在行有效
                            board[i][j] = c;
                            if (helper_DFS(board)) return true;//递归
                            else board[i][j] = '.';//不符合 设回'.'
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid_still_Sudoku(char[][] board, int i, int j, char c) {
        //在第i行j列填入某個字符 檢測是否仍為有效数独
        //检查行有没有重复的
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][col] == c) {
                return false;
            }
        }
        //检查列有没有重复的
        for (int row = 0; row < 9; row++) {
            if (row != i && board[row][j] == c) {
                return false;
            }
        }
        //检查所在九宫格有没有重复的
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (row != i && col != j && board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
