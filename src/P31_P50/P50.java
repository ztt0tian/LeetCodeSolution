/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn 
 */

package P31_P50;

/**
 * @author zhaotian
 * @date 2018/9/9 15:53
 */
public class P50 {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -3));
        System.out.println(myPow2(2.00000, -3));
    }
    public static double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = myPow(x, n/2);
        if (n%2 == 0)
        {
            return half*half;
        }
        else if (n>0)
        {
            return half*half*x;
        }
        else
        {
            return half/x*half;
        }
    }
    public static double myPow2(double x, int n) {
        boolean reverse = false;
        if(n < 0) {
            n = -n;
            reverse = true;
        }
        double tmp = x;
        double res = 1;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) res *= tmp;
            n = n >> 1;
            tmp = tmp * tmp;
        }
        return reverse ? 1.0/res : res;
    }
}
