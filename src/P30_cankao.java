import java.util.*;

/**
 * @author zhaotian
 * @date 2018/7/13 17:03
 */
//给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
//
//        注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
//
//        示例 1:
//
//        输入:
//        s = "barfoothefoobarman",
//        words = ["foo","bar"]
//        输出: [0,9]
//        解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
//        输出的顺序不重要, [9,0] 也是有效答案。
//
//        示例 2:
//
//        输入:
//        s = "wordgoodstudentgoodword",
//        words = ["word","student"]
//        输出: []
//        思路仍然是维护一个窗口，如果当前单词在字典中，则继续移动窗口右端，
//        否则窗口左端可以跳到字符串下一个单词了。假设源字符串的长度为n，
//        字典中单词的长度为l。因为不是一个字符，所以我们需要对源字符串所有长度为l的子串进行判断。
//        做法是i从0到l-1个字符开始，得到开始index分别为i, i+l, i+2*l, ...的长度为l的单词。这样就
//        可以保证判断到所有的满足条件的串。因为每次扫描的时间复杂度是O(2*n/l)(每个单词不会被访问
//        多于两次，一次是窗口右端，一次是窗口左端)，总共扫描l次（i=0, ..., l-1)，所以总复杂度是
//        O(2*n/l*l)=O(n)，是一个线性算法。空间复杂度是字典的大小，即O(m*l)，其中m是字典的单词数量。
public class P30_cankao {
    public static void main(String[] args) {
        String s = "barfoobarfoothefoobarmanbar";
        String[] words = {"foo","bar"};
        ArrayList<Integer> res=findSubstring(s,words);
        System.out.println(res);
    }
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S==null || S.length()==0 || L==null || L.length==0)
            return res;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<L.length;i++)
        {
            //统计字符串数组中出现各个单词的个数
            if(map.containsKey(L[i]))
            {
                map.put(L[i],map.get(L[i])+1);
            }
            else
            {
                map.put(L[i],1);
            }
        }
        //L[0].length()就表示一个单词的长度
        for(int i=0;i<L[0].length();i++)//表示窗口的起始位只能是一个单词的下标位+n*单位长度
        {
            HashMap<String,Integer> curMap = new HashMap<String,Integer>();
            int count = 0;
            int left = i;
            for(int j=i;j<=S.length()-L[0].length();j+=L[0].length())//确定窗口左端和右端 以及每步所取长度
            {
                String str = S.substring(j,j+L[0].length());//获取窗口左端的第一个符合单词长度的单词

                if(map.containsKey(str))//该单词符合条件
                {//统计该单词个数，添加到当前Map集合中
                    if(curMap.containsKey(str))
                        curMap.put(str,curMap.get(str)+1);
                    else
                        curMap.put(str,1);
                    if(curMap.get(str)<=map.get(str))//某个单词当先出现次数小于在数组中出现的次数
                        count++;//统计符和条件的单词总个数
                    else//某个单词当前出现次数大于在数组中出现的次数
                    {
                        while(curMap.get(str)>map.get(str))//循环直至当前Map中出现的特定单词的次数小于等于在数组中出现的数组
                        {
                            String temp = S.substring(left,left+L[0].length());
                            if(curMap.containsKey(temp))//
                            {
                                curMap.put(temp,curMap.get(temp)-1);
                                if(curMap.get(temp)<map.get(temp))
                                    count--;
                            }
                            left += L[0].length();//窗口右移一个单位（单词长度）
                        }
                    }
                    if(count == L.length)//如果连续出现所有单词，则添加窗口左端标号
                    {
                        res.add(left);
                        //if(left<)
                        String temp = S.substring(left,left+L[0].length());
                        if(curMap.containsKey(temp))
                            curMap.put(temp,curMap.get(temp)-1);
                        count--;
                        left += L[0].length();//窗口右移
                    }
                }
                else //如果中途当前Map不含字符串数组中的单词则说明中断了，一切置为初始状态
                {
                    curMap.clear();
                    count = 0;
                    left = j+L[0].length();
                }
            }
        }
        return res;
    }
}
