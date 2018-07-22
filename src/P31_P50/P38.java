package P31_P50;

/**
 * @author zhaotian
 * @date 2018/7/20 17:10
 */
//报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//
//        1 被读作  "one 1"  ("一个一") , 即 11。
//        11 被读作 "two 1s" ("两个一"）, 即 21。
//        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//
//        给定一个正整数 n ，输出报数序列的第 n 项。
//
//        注意：整数顺序将表示为一个字符串。
//
//        示例 1:
//
//        输入: 1
//        输出: "1"
//
//        示例 2:
//
//        输入: 4
//        输出: "1211"
//

public class P38 {
    public static void main(String[] args) {

        System.out.println(countAndSay(6));
    }
    public static String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        return helper(countAndSay(n-1));
    }
    public static String helper(String str){
        String res="";
        char flag=str.charAt(0);
        int flag_court=0;
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i)==flag){
                flag_court+=1;//几个flag char
            }
            else {//连续字符中断
                res+=String.valueOf(flag_court)+String.valueOf(flag);
                flag=str.charAt(i);//更换flag char
                flag_court=1;//计数置1
            }
        }
        res+=String.valueOf(flag_court)+String.valueOf(flag);
        return res;
    }
}
