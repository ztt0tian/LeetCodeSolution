package P12_P30;

import java.util.*;

/**
 * @author zhaotian
 * @date 2018/6/20 15:10
 */
public class P17 {
    public static void main(String[] args) {
        String digits="201233";
        List<String> strings=letterCombinations(digits);
        for (String s:strings
             ) {
            System.out.println(s);
        }
    }
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> strings=new LinkedList<>();
        if(digits.isEmpty()) return strings;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        strings.add("");
        while (strings.peek().length()!=digits.length()){
            String first_out=strings.remove();//第一个元素（非完整字符串即长度不等于digits的长度）出队列并保存下来因为还要在其后追加
            String mapp_string=mapping[(digits.charAt(first_out.length()))-'0'];
            for(char c:mapp_string.toCharArray()){
                strings.addLast(first_out+c);
            }
        }
        return strings;
    }
}
