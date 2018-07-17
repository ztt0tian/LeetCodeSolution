package P12_P30;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/7/3 16:15
 */
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
//        例如，给出 n = 3，生成结果为：
//
//        [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]
//    每找到一个左括号，就在其后面加一个完整的括号，最后再在开头加一个()，就形成了所有的情况
//       勉强通过，但是时间花费太高了
public class P22_too_long {
    public static void main(String[] args) {
        List<String> res=generateParenthesis(4);
        for(String s:res){
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return null;
        }
        if(n==1) {
            res.add("()");
            return res;
        }
        else {
            for(String each_str:generateParenthesis(n-1)) {
                res.add(each_str+"(" + ")");
                int start=0;
                int index;
                while ((index=each_str.indexOf("(",start))!=-1){
                    res.add(each_str.substring(0,index+1)+"()"+each_str.substring(index+1));
                    start=index+1;
                }
                res.remove(each_str);
                //去重
                Set<String> stringSet=new HashSet<>();
                stringSet.addAll(res);
                res.clear();
                res.addAll(stringSet);

            }

        }
        return res;
    }
}