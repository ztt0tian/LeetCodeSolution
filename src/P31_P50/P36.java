package P31_P50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/7/19 15:39
 */
//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
public class P36 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', ',', '7', '.', '.', '.', '.'},
                {'6', '3', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        List<Integer> temp=new ArrayList<>();
        //每一行
        for (int row=0;row<9;row++){
            temp.clear();
            for (int col = 0; col <9 ; col++) {
                char c_car=board[row][col];
                if(c_car!='.'){
                    if(temp.contains(c_car-'0')){
                        return false;
                    }
                    else temp.add(c_car-'0');
                }
            }
        }
        //每一列
        for (int col=0;col<9;col++){
            temp.clear();
            for (int row = 0; row <9 ; row++) {
                char c_car=board[row][col];
                if(c_car!='.'){
                    if(temp.contains(c_car-'0')){
                        return false;
                    }
                    else temp.add(c_car-'0');
                }
            }
        }
        //第一个3X3
        for (int row = 0; row <9 ; row+=3) {
            for (int col=0;col<9;col+=3){
                temp.clear();
                for (int i = row; i <row+3 ; i++) {
                    for (int j = col; j <col+3 ; j++) {
                        char c_car=board[i][j];
                        if(c_car!='.'){
                            if(temp.contains(c_car-'0')){
                                return false;
                            }
                            else temp.add(c_car-'0');
                        }
                    }
                }
            }
        }
        return true;
    }
}
