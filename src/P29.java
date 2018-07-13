/**
 * @author zhaotian
 * @date 2018/7/13 11:14
 */
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
//        返回被除数 dividend 除以除数 divisor 得到的商。
//
//        示例 1:
//
//        输入: dividend = 10, divisor = 3
//        输出: 3
//
//        示例 2:
//
//        输入: dividend = 7, divisor = -3
//        输出: -2
//
//        说明:
//
//        被除数和除数均为 32 位有符号整数。
//        除数不为 0。
//        假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//趁此机会 学习一下利用位运算来 实现加减乘除运算
public class P29 {
    public static void main(String[] args) {
//        System.out.println(add(1,3));
//        System.out.println(add2(-1,-3));
//        System.out.println(subtraction(-1,-3));
//        System.out.println(multiply(3,-5));
//        System.out.println(multiply2(-3,-5));
//        System.out.println(division(10,-5));
//        System.out.println(division2(10,-5));
        System.out.println(Math.abs(Integer.MIN_VALUE+1));
        System.out.println(divide(Integer.MIN_VALUE,2));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);


    }

    /**
     * 位运算实现加法
     * 不管是十进制加法还是二进制加法，其加的的过程在每一位看分为‘和’、‘进位’两个部分。‘和’要留在当前位，
     * ‘进位’加入到下一位。
     * 我们现在关注二进制加法。发现一个特点。
     * 位的异或运算跟求'和'的结果一致：
     * 异或 1^1=0 1^0=1 0^0=0
     * 求和 1+1=0 1+0=1 0+0=0
     * 位的与运算跟求'进位‘的结果一致：
     * 位与 1&1=1 1&0=0 0&0=0
     * 进位 1+1=1 1+0=0 0+0=0
     * @param a
     * @param b
     * @return
     */
    public  static int  add(int a, int b) //递归形式
    {
        if(b==0) //递归结束条件：如果右加数为0，即不再有进位了，则结束。
            return a;
        int s = a^b;
        int c = (a&b)<<1; //进位左移1位，达到进位的目的。
        return add(s, c); //再把'和'和'进位'相加。递归实现。
    }
    public static int add2(int a, int b) //非递归形式
    {
        int s, c;
        while(b != 0)
        {
            s = a^b;
            c = (a&b)<<1;
            a = s;
            b = c;
        }
        return a;
    }

    /**
     * 位运算实现减法 在加法的基础上实现
     * 在ALU中，当我求a-b，其实是求[a-b]补。
     * 因为有[a-b]补=[a]补 - [b]补= [a]补+[-b]补。
     * 所以我就要先求出-b。求一个数的负的操作
     * 是将其连符号位一起取反然后加1
     * @param a
     * @param b
     * @return
     */
    public static int subtraction(int a,int b){
        return add(a,getNegtive(b));
    }

    /**
     * 将一个数取负
     * @param num
     * @return
     */
    public static int getNegtive(int num){
        return add(~num,1);
    }
    /**
     *很直观，就是用循环加法替代乘法。a*b，就是把a累加b次。时间复杂度为O(N)。
     * @param a
     * @param b
     * @return
     */
    public static int multiply(int a, int b){
        boolean flag=false;//符号标志 是否为非负数
        if(getSign(a)==getSign(b)){
            flag=true;
        }
        a=bepositive(a);
        b=bepositive(b);
        int ans=0;
        while (b!=0){
            ans=add(ans,a);
            b=subtraction(b,1);
        }
        if(flag==false){
            ans=getNegtive(ans);
        }
        return ans;
    }

    /**
     * 在二进制数上做乘法,利用位运算
     * 根据乘数的每一位为0或1时，将被乘数错位的加在积上
     * @param a
     * @param b
     * @return
     */
    public static int multiply2(int a, int b){
        boolean flag=false;//符号标志 是否为非负数
        if(getSign(a)==getSign(b)){
            flag=true;
        }
        a=bepositive(a);
        b=bepositive(b);
        int ans=0;
        while (b!=0){
            if((b&1)!=0){
                ans=add(ans,a);
            }
            a=a<<1;////把a错位加在积上，无论b的当前为是1还是0，a都要左移一位
            b=b>>1;//从最低位开始依次判断b的每一位，若为1则加a后再右移，若为0，则继续右移
        }
        if(flag==false){
            ans=getNegtive(ans);
        }
        return ans;
    }

    /**
     * 获取符号位，依次确定为是否为负数
     * 取一个数的符号，看是正还是负
     * @param num
     * @return
     */
    public static int getSign(int num){
        return (num>>31);
    }

    /**
     * 将一个数变为正数，如果本来就是正，
     * 则不变；如果是负，则变为相反数。
     * 注意对于-2147483648，求负会溢出。
     * @param num
     * @return
     */
    public static int bepositive(int num){
        if(num>>31==-1){//符号位为-1表示为负数
            return getNegtive(num);
        }
        return num;
    }

    /**
     * 从被除数上减去除数，看能减多少次之后变得不够减。时间复杂度为O(N)。
     * @param a
     * @param b
     * @return
     */
    public static int division(int a, int b){
        boolean flag=false;//符号标志 是否为非负数
        if(getSign(a)==getSign(b)){
            flag=true;
        }
        a=bepositive(a);
        b=bepositive(b);
        int ans=0;
        a=subtraction(a,b);
        while (a>=0){
            ans=add(ans,1);//每次减一 商加一
            a=subtraction(a,b);
        }
        if(flag==false){
            ans=getNegtive(ans);
        }
        return ans;
    }

    /**
     * 采用类似二分法的思路，从除数*最大倍数开始测试，
     * 如果比被除数小，则要减去。下一回让除数的倍数减少
     * 为上一次倍数的一半，这样的直到倍数为1时，就能把
     * 被除数中所有的除数减去，并得到商。时间复杂度降
     * 低到O(logN)。
     * @param a
     * @param b
     * @return
     */
    public static int division2(int a, int b){
        boolean flag=false;//符号标志 是否为非负数
        if(getSign(a)==getSign(b)){
            flag=true;
        }
        a=bepositive(a);
        b=bepositive(b);
        int ans=0;
        int i=31;
        while (i>=0){
            if((a>>i)>=b){        //比较a是否大于b<<i，避免直接比较，因为不确定b<<i是否溢出 所以用较大的那个右移
                ans=add(ans,(1<<i));
                a=subtraction(a,(b<<i));
            }
            i=subtraction(i,1);//倍数缩小一半
        }
        if(flag==false){
            ans=getNegtive(ans);
        }
        return ans;
    }

    /**
     * 单独实现除法
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if(divisor == 0)
        {//除数为0时返回最大值
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend^divisor)>>>31 == 1;//两个数亦或 看最高位即符号位 是否为1，1代表结果会为负数，0代表结果为正数
        int res = 0;
        if(dividend == Integer.MIN_VALUE)
        {//被除数为最小值
            //math.abs(Integer.MIN_VALUE)=Integer.MIN_VALUE
            dividend += Math.abs(divisor);//加上一倍除数的正值，避免在求绝对值时越界出错
            if(divisor == -1)
            {//除法溢出 返回最大值
                return Integer.MAX_VALUE;
            }
            res++;//最后的商值加一 与之前被除数加的那个数抵消
        }
        if(divisor == Integer.MIN_VALUE)
        {
            //被除数为最小值时 返回0
            return res;
        }
        //将除数与被除数都转化为正数
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while(divisor <= (dividend>>1))//将除数不断左移直至大于被除数之前的
        {
            divisor <<= 1;
            digit++;
        }
        while(digit>=0)
        {
            if(dividend>=divisor)//被除数大于除数
            {
                res += 1<<digit;//商值加上2的digit次方
                dividend -= divisor;//减去相应值
            }
            divisor >>= 1;
            digit--;//递减至1
        }
        return isNeg?-res:res;
    }
}
