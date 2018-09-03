package P31_P50;

/**
 * @author zhaotian
 * @date 2018/7/25 15:27
 */
//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
//        '?' 可以匹配任何单个字符。
//        '*' 可以匹配任意字符串（包括空字符串）。
//
//        两个字符串完全匹配才算匹配成功。
//
//        说明:
//
//        s 可能为空，且只包含从 a-z 的小写字母。
//        p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
//              超出时间用例
//              初次想到暴力法
//            "babaabbbbbaaaaabbaababbaaaaaaabbaabaabbbabbaabbbbb"
//            "*ba**bbbb"
public class P44_time_too_long {
    public static void main(String[] args) {
        String s = "babaabbbbbaaaaabbaababbaaaaaaabbaabaabbbabbaabbbbb";
        String p = "*ba**bbbb";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null) {
            return p == null;
        }
        if (p == null) {
            return s == null;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return p.length() == 0 || remain(p, 0);
        } else return matchHelper(s, p, 0, 0);
    }

    private static boolean matchHelper(String s, String p, int start_s, int start_p) {
        //检查下标
        if (start_s < s.length() && start_p < p.length()) {
            if (p.charAt(start_p) == s.charAt(start_s) || p.charAt(start_p) == '?') {//均为a-z
                return matchHelper(s, p, start_s + 1, start_p + 1);
            } else if (p.charAt(start_p) == '*') {
                if (!matchHelper(s, p, start_s + 1, start_p)) {
                    return matchHelper(s, p, start_s, start_p + 1);
                }
                return matchHelper(s, p, start_s + 1, start_p);
            } else
                return false;
        }
        if (start_s == s.length()) {
            return start_p == p.length() || remain(p, start_p);
        }
        return false;
    }

    private static boolean remain(String p, int start_p) {
        for (int i = start_p; i < p.length(); i++) {
            if (p.charAt(i) != '*') return false;
        }
        return true;
    }
}
