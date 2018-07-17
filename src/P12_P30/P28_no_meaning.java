package P12_P30;

/**
 * @author zhaotian
 * @date 2018/7/12 12:27
 */
//实现 strStr() 函数。
//
//        给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//
//        示例 1:
//
//        输入: haystack = "hello", needle = "ll"
//        输出: 2
//
//        示例 2:
//
//        输入: haystack = "aaaaa", needle = "bba"
//        输出: -1

public class P28_no_meaning {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);//如果单纯是这样那没啥意义了
    }
}
