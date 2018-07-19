package P31_P50;

import java.util.Stack;

/**
 * @author zhaotian
 * @date 2018/7/19 10:20
 */
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//        示例 1:
//
//        输入: "(()"
//        输出: 2
//        解释: 最长有效括号子串为 "()"
//
//        示例 2:
//
//        输入: ")()())"
//        输出: 4
//        解释: 最长有效括号子串为 "()()"
public class P32 {
    public static void main(String[] args) {
        //String s="(())";
        //String s="()()()()";
        //String s="(()";
        //String s="(()()";
        //String s="()(()()";
        //String s="()(())";
        //String s="(()(((()";
        String s=")()())";
        //String s="())";
        System.out.println(longestValidParentheses(s));
    }
    //记录未匹配的括号位置，然后两两相减找到最大值，过了，但速度并不快。
    public static int longestValidParentheses(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        int start=0;
        int max=0;
        Stack<Integer> stacks=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stacks.push(i);
            }
            else {
                if(!stacks.isEmpty()){
                    stacks.pop();
                    max=stacks.isEmpty()?Math.max(max,i-start+1):Math.max(max,i-stacks.peek());//关键，决定max
                }
                else {
                    start=i+1;//中断 起始位置右移
                }
            }
        }
        return max;
    }
}
