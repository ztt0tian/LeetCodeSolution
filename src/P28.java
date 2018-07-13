/**
 * @author zhaotian
 * @date 2018/7/12 12:38
 */
public class P28 {
    public static void main(String[] args) {
        String haystack = "", needle = "";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        if (needle.length()==0){
            return 0;
        }
        if (needle.length()!=0&&haystack.length()==0){
            return -1;
        }
        int needle_next[]=getNext(needle);
        char[]hatstack_arry=haystack.toCharArray();
        char[]needle_arry=needle.toCharArray();
        int j=0;
        for(int i=0;i<hatstack_arry.length;i++){
            while (i<hatstack_arry.length&&j<needle_arry.length){

                if(hatstack_arry[i]==needle_arry[j]){
                    i++;
                    j++;
                }
                else if(j==0&&hatstack_arry[i]!=needle_arry[j]){
                    i++;
                }
                else j=needle_next[j];
            }
            if(j==needle_arry.length) return i-j;
        }
        return -1;
    }
    //next值就相当于最大前后缀
    public static int[] getNext(String ps) {

        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j=0;
        int k=-1;
        while (j<p.length-1){
            if(k==-1||p[j]==p[k]){
                next[++j]=++k;
            }
            else k=next[k];
        }
        return next;

    }
}
