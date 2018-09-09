/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P31_P50;

/**
 * @author zhaotian
 * @date 2018/9/9 15:53
 */
public class P50_time_too_long {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -3));
    }
    public static double myPow(double x, int n) {
        if (n==1){
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n <0) {
            return 1/myPow(x, -n);
        }
        else {
            if (n % 2 == 0) {
                return myPow(x, n / 2) * myPow(x, n / 2);
            } else {
                return myPow(x, n / 2) * myPow(x, n / 2 + 1);
            }
        }
    }
}
