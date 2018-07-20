package P31_P50;

import java.util.*;

/**
 * @author zhaotian
 * @date 2018/7/19 16:16
 */
//编写一个程序，通过已填充的空格来解决数独问题。
//
//        一个数独的解法需遵循如下规则：
//
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//        空白格用 '.' 表示。
//    Note:
//
//            给定的数独序列只包含数字 1-9 和字符 '.' 。
//            你可以假设给定的数独只有唯一解。
//            给定数独永远是 9x9 形式的。

    //最初的思考 求出每个空格可能值，再依据一定规则来筛选和确定 但是涉及的规则有很多 且实现起来较为麻烦 很难考虑全
    //如唯一规则 隐含唯一规则 数对规则等等 可到https://jingyan.baidu.com/article/7082dc1c178459e40a89bd26.html了解

public class P37_test_no_success {
    public static void main(String[] args) {
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };//通過
//        char[][] board={
//                {'.','.','9','7','4','8','.','.','.'},
//                {'7','.','.','.','.','.','.','.','.'},
//                {'.','2','.','1','.','9','.','.','.'},
//                {'.','.','7','.','.','.','2','4','.'},
//                {'.','6','4','.','1','.','5','9','.'},
//                {'.','9','8','.','.','.','3','.','.'},
//                {'.','.','.','8','.','3','.','2','.'},
//                {'.','.','.','.','.','.','.','.','6'},
//                {'.','.','.','2','7','5','9','.','.'}
//        };
        char[][] board={
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','6','.','2','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','9','8','6','2','4','1'},
                {'2','6','4','3','1','7','5','9','8'},
                {'1','9','8','5','2','4','3','6','7'},
                {'.','.','.','8','6','3','.','2','.'},
                {'.','.','.','4','9','1','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };
        solveSudoku(board);
        for (int i = 0; i <9 ; i++) {
            System.out.print("{");
            for (int j = 0; j < 9; j++) {
                System.out.print("'"+board[i][j]+"'"+",");
            }
            System.out.println("}");
        }
    }
    public static void solveSudoku(char[][] board) {
        HashMap<Character,Integer> row_collector=new HashMap<>();
        HashMap<Character,Integer> col_collector=new HashMap<>();
        for (int i = 0; i <9 ; i++) {
            row_collector.clear();
            for (int j = 0; j <9 ; j++) {
                if(board[i][j]=='.'){
                    Set<Character> poses = get_blank_possiblle(board,i,j);//空格可能出现的字符集合
                    if(poses.size()==1){//必然值
                        board[i][j]=poses.iterator().next();
                        solveSudoku(board);//每次確定 更新
                    }
                    else {//隐含唯一数法:某一行某一列或某个九宫有一个候选数只出现在一个格子里面，那么这个格子必然是这个数字
                        for (char u_char:poses) {
                            if (!row_collector.containsKey(u_char)) {//字符第一次加入，设其value为所在列
                                row_collector.put(u_char, j);
                            }
                            else {
                                row_collector.put(u_char,-1);//之前已经有该字符,设其value为-1
                            }
                        }
                        if(j==8){//某一行 隐含唯一
                            boolean modify_flag=false;//修改标志
                            for(Character key:row_collector.keySet())
                            {
                                if(row_collector.get(key)!=-1){
                                    board[i][row_collector.get(key)]=key;
                                    modify_flag=true;
                                }
                            }
                            if (modify_flag){
                                solveSudoku(board);//更新
                            }
                        }
                        if(i==8){//某一列 隐含唯一
                            boolean modify_flag2=false;//修改标志
                            for(Character key:col_collector.keySet())
                            {
                                if(col_collector.get(key)!=-1){
                                    board[col_collector.get(key)][j]=key;
                                    modify_flag2=true;
                                }
                            }
                            if (modify_flag2){
                                solveSudoku(board);
                            }
                        }
                    }
                }
            }
        }
    }
    public static Set<Character> get_blank_possiblle(char[][] board,int row,int col){
        Set<Character> poses=new HashSet<>();
        List<Character> all= Arrays.asList('1','2','3','4','5','6','7','8','9');
        Set<Character> containes = get_contain_already(board,row,col);
        for (char x:all) {
            if (!containes.contains(x)){
                poses.add(x);
            }
        }
        return poses;
    }
    public static Set<Character> get_contain_already(char[][] board, int row, int col) {
        Set<Character> containes=new HashSet<Character>();
        for(int i=0;i<9;i++){//所在行包括的所有数字字符
            if(board[row][i]!='.'){
                containes.add(board[row][i]);
            }
            if(board[i][col]!='.'){//所在列包括的所有数字字符
                containes.add(board[i][col]);
            }
        }
        //所在3X3包括的所有数字字符
        containes.addAll(get_contain_3_3(board,row,col));
        return containes;
    }
    public static Set<Character> get_contain_3_3(char[][] board, int row, int col){
        Set<Character> containes=new HashSet<Character>();
        if(row<3){
            //1至3行
            if(col<3){
                //1至3列
                for (int i = 0; i <3 ; i++) {
                    for (int j = 0; j <3; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
            else if(col>=3&&col<6){
                //4至6列
                for (int i = 0; i <3 ; i++) {
                    for (int j = 3; j <6; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
            else {
                //7至9列
                for (int i = 0; i <3 ; i++) {
                    for (int j = 6; j <9; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
        }
        else if(row>=3&&row<6){
            //4至6行
            if(col<3){
                //1至3列
                for (int i = 3; i <6 ; i++) {
                    for (int j = 0; j <3; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
            else if(col>=3&&col<6){
                //4至6列
                for (int i = 3; i <6 ; i++) {
                    for (int j = 3; j <6; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
            else {
                //7至9列
                for (int i = 3; i <6 ; i++) {
                    for (int j = 6; j <9; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
        }
        else {
            //7至9行
            if(col<3){
                //1至3列
                for (int i = 6; i <9 ; i++) {
                    for (int j = 0; j <3; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
            else if(col>=3&&col<6){
                //4至6列
                for (int i = 6; i <9 ; i++) {
                    for (int j = 3; j <6; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
            else {
                //7至9列
                for (int i = 6; i <9 ; i++) {
                    for (int j = 6; j <9; j++) {
                        if (board[i][j]!='.') {
                            containes.add(board[i][j]);
                        }
                    }
                }
            }
        }
        return containes;
    }
}
//        ["5","1","9","7","4","8","6","3","2"],
//        ["7","8","3","6","5","2","4","1","9"],
//        ["4","2","6","1","3","9","8","7","5"],
//        ["3","5","7","9","8","6","2","4","1"],
//        ["2","6","4","3","1","7","5","9","8"],
//        ["1","9","8","5","2","4","3","6","7"],
//        ["9","7","5","8","6","3","1","2","4"],
//        ["8","3","2","4","9","1","7","5","6"],
//        ["6","4","1","2","7","5","9","8","3"]
