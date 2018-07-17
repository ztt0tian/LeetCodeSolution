package P12_P30;

/**
 * @author zhaotian
 * @date 2018/6/13 16:36
 */
public class P13 {
    public static void main(String[] args) {
        String s = "abcdebdesa";
        System.out.println(s.indexOf("b"));
        System.out.println(intTos("MCMXCIV"));
    }

    public static int intTos(String s) {
//        String ge[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};//个位0-9
//        String shi[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//十位10-90
//        String bai[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//百位100-900
//        String qian[]={"","M","MM","MMM"};//千位1000-3000
//        int qian_int[]={0,1000,2000,3000};//"" "M" "MM" "MMM"
//        int bai_int[]={0,100,200,300,400,500,600,700,800,900};//"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"
//        int shi_int[]={0,10,20,30,40,50,60,70,80,90};//"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"
//        int ge_int[]={0,1,2,3,4,5,6,7,8,9};//"","I","II","III","IV","V","VI","VII","VIII","IX"
//        字符          数值
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000

        int i = 0;
        int value = 0;
        while (i < s.length()) {
            switch (s.charAt(i)) {
                case 'M':
                    value += 1000;
                    i++;
                    break;
                case 'D':
                    value += 500;
                    i++;
                    break;
                case 'C':
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {//CM

                        value += 900;
                        i = i + 2;
                        break;
                    } else if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {//CD
                        value += 400;
                        i = i + 2;
                        break;
                    } else value += 100;
                    i++;
                    break;
                case 'L':
                    value += 50;
                    i++;
                    break;
                case 'X':
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {//CM
                        value += 90;
                        i = i + 2;
                        break;
                    } else if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {//CD
                        value += 40;
                        i = i + 2;
                        break;
                    } else value += 10;
                    i++;
                    break;
                case 'V':
                    value += 5;
                    i++;
                    break;
                case 'I':
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {//CM
                        value += 9;
                        i = i + 2;
                        break;
                    } else if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {//CD
                        value += 4;
                        i = i + 2;
                        break;
                    } else value += 1;
                    i++;
                    break;
            }
        }
        return value;
    }
}
