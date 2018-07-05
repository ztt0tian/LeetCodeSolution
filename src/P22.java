import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/7/5 14:28
 */
//        对于这种列出所有结果的题首先还是考虑用递归Recursion来解，
//        由于字符串只有左括号和右括号两种字符，而且最终结果必定是左括号3个，
//        右括号3个，所以我们定义两个变量left和right分别表示剩余左右括号的个数，
//        如果在某次递归时，左括号的个数大于右括号的个数，说明此时生成的字符串中
//        右括号的个数大于左括号的个数，即会出现')('这样的非法串，所以这种情况直接
//        返回，不继续处理。如果left和right都为0，则说明此时生成的字符串已有3个
//        左括号和3个右括号，且字符串合法，则存入结果中后返回。如果以上两种情况
//        都不满足，若此时left大于0，则调用递归函数，注意参数的更新，若right大于
//        0，则调用递归函数，同样要更新参数。
public class P22 {
    public static void main(String[] args) {
        List<String> res=generateParenthesis(4);
        for(String s:res){
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(n,n,"",res);
        return res;
    }

    private static void helper(int left, int right, String s, List<String> res) {
        if(left<0||right<0||right<left){
            return;
        }
        if(left==0&&right==0){
            //此时有n对括号，添加到res中
            res.add(s);
        }
        helper(left-1,right,s+"(",res);//多加一个'('
        helper(left,right-1,s+")",res);//多加一个')'
    }
}
