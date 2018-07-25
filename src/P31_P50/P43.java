package P31_P50;

/**
 * @author zhaotian
 * @date 2018/7/24 16:33
 */
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
//        示例 1:
//
//        输入: num1 = "2", num2 = "3"
//        输出: "6"
//
//        示例 2:
//
//        输入: num1 = "123", num2 = "456"
//        输出: "56088"
//
//        说明：
//
//        num1 和 num2 的长度小于110。
//        num1 和 num2 只包含数字 0-9。
//        num1 和 num2 均不以零开头，除非是数字 0 本身。
//        不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。


public class P43 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    /**
     * 思路参考https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation?page=7
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if (num1==null||num2==null){
            return "";
        }
        int l1 = num1.length(), l2 = num2.length();
        int[] pos = new int[l1 + l2];//结果的最大位數
        /**
         * 从num1和num2选择的两个个位数相乘的结果的位置与所选两个数的下标（分别为i,j）有一定关系
         * 两个个位数相乘位数必定不超过二，不是一位就是两位。统一看做两位 分成个位与十位（当只有一位时十位看成0）。
         * 其中十位所在位置在结果数组中的下标位i+j
         * 其中个位所在位置在结果数组中的下标位i+j+1
         */
        for (int i = l1 - 1; i >= 0; i--) {//从num1的最低位开始
            for (int j = l2 - 1; j >= 0; j--) {//从num2的最低位开始
                int u_mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');//每次求两个一位数的乘积（最多两位数）
                int p1 = i + j, p2 = i + j + 1;//对应在pos中下标
                int sum = u_mul + pos[p2];//要加上之前的进位（可能因此会产生进位）
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }

        }
        StringBuilder res = new StringBuilder();
        for (int u : pos) {
            if (!(res.length() == 0 && u == 0)) {
                res.append(u);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    //    public static String multiply(String num1, String num2) {
//        if (num1 == null||num2==null||num1.length()==0||num2.length()==0) {
//            return "";
//        }
//        if (num1.charAt(0) == '0'|| num2.charAt(0)=='0') {
//            return "0";
//        }
//        int num=0;
//        for (int i = num1.length()+num2.length(); i >0 ; i--) {
//
//        }
//        return num1;
//    }
//    public static String multiply(String num1, String num2) {
//        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
//            return "";
//        if (num1.charAt(0) == '0')
//            return "0";
//        if (num2.charAt(0) == '0')
//            return "0";
//        StringBuilder res = new StringBuilder();
//        int num = 0;
//        for (int i = num1.length() + num2.length(); i > 0; i--) {
//            for (int j = Math.min(i - 1, num1.length()); j > 0; j--) {
//                if (i - j <= num2.length()) {
//                    num += (int) (num1.charAt(j - 1) - '0') * (int) (num2.charAt(i - 1 - j) - '0');
//                }
//            }
//            if (i != 1 || num > 0)
//                res.append(num % 10);
//            num = num / 10;
//        }
//        return res.reverse().toString();
//    }
}
