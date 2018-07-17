package P12_P30;

/**
 * @author zhaotian
 * @date 2018/6/13 16:36
 */
public class P12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
    public static String intToRoman(int num) {
        String ge[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};//个位0-9
        String shi[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//十位10-90
        String bai[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//百位100-900
        String qian[]={"","M","MM","MMM"};//千位1000-3000
        String str="";
        return str+qian[num/1000]+bai[num%1000/100]+shi[num%100/10]+ge[num%10/1];
    }
}
