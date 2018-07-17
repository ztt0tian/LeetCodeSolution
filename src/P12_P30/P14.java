package P12_P30;

/**
 * @author zhaotian
 * @date 2018/6/13 16:36
 */
public class P14 {
    public static void main(String[] args) {
        String[] strings={"dsad","dasd","da"};
        System.out.println(longestCommonPrefix(strings));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String str_same="";
        int index=0;//字符串索引
       w: while(index<Min_String_len(strs)) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(index) != strs[i + 1].charAt(index)) {
                    break w;
                }
            }
            index++;
        }
        str_same+=strs[0].substring(0,index);
       return str_same;
    }

    private static int Min_String_len(String[] strs) {
        if(strs.length==0){
            return 0;
        }
        int min=strs[0].length();
        for(int i=1;i<strs.length;i++){
            if(min>strs[i].length()){
                min=strs[i].length();
            }
        }
        return min;
    }
}
