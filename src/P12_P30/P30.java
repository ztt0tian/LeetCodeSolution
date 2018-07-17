package P12_P30;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author zhaotian
 * @date 2018/7/17 15:36
 */
public class P30 {
    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = {"foo","bar"};
        //wordgoodgoodgoodbestword  "word","good","best","good"
        String s="wordgoodgoodgoodbestword";
        String[] words={"word","good","best","good"};
        ArrayList<Integer> res=findSubstring(s,words);
        System.out.println(res);
    }
    public static ArrayList<Integer> findSubstring(String S, String[] words) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(S==null||words==null||S.length()==0||words.length==0){
            return res;
        }
        //处理words信息 单词--个数
        HashMap<String,Integer> words_map=new HashMap<String, Integer>();
        for (String i_words: words){
            if(words_map.containsKey(i_words)){
                words_map.put(i_words,words_map.get(i_words)+1);
            }
            else words_map.put(i_words,1);
        }
        for (int i = 0; i <words[0].length() ; i++) {//单词的长度对应着各个基位
            //每次从基位开始的一些初始化工作
            HashMap<String,Integer> cur_words_map=new HashMap<String, Integer>();//当前集合中的单词信息
            int count=0;
            int left=i;//窗口左端默认为开始基位
            //遍历S字符串
            for (int j=i;j<=S.length()-words[0].length();j+=words[0].length()){//每次递增都已一个单词的跨度为单位
                String str=S.substring(j,j+words[0].length());
                if(words_map.containsKey(str)) {
                    if (cur_words_map.containsKey(str)) {
                        cur_words_map.put(str, cur_words_map.get(str) + 1);
                    }
                    else cur_words_map.put(str, 1);
                    //一定要考虑单词的出现次数
                    if(cur_words_map.get(str)<=words_map.get(str)){//因为在添加之后，所以包含=
                        count++;
                    }
                    else{
                        while (cur_words_map.get(str)>words_map.get(str)){
                            String t_str=S.substring(left,left+words[0].length());
                            if(cur_words_map.containsKey(t_str)){
                                cur_words_map.put(t_str,cur_words_map.get(t_str)-1);
                                if(cur_words_map.get(t_str)<words_map.get(t_str)){
                                    count--;//如果右移去掉的单词不是多余的 则要将当前满足的单词个数减一
                                }
                            }
                            left+=words[0].length();//窗口右移
                        }
                    }
                    if (count == words.length) {
                        res.add(left);
                        String temp=S.substring(left,left+words[0].length());
                        if(cur_words_map.containsKey(temp)){
                            cur_words_map.put(temp,cur_words_map.get(temp)-1);
                        }
                        count--;
                        left+=words[0].length();
                    }
                }
                else {//重新初始化
                    cur_words_map.clear();
                    count=0;
                    left=j+words[0].length();
                }
            }
        }

        return res;
    }
}
