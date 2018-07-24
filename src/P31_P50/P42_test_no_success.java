package P31_P50;

/**
 * @author zhaotian
 * @date 2018/7/24 9:35
 */
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//        示例:
//
//        输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//        输出: 6
public class P42_test_no_success {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};//6
//        int[] height = {9,6,8,8,5,6,3};//3
        int[] height = {5,2,1,2,1,5};//14
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int sum = 0;
        if (height == null || height.length <= 2) {
            return sum;
        }
        int left = 0;
        int right = 0;
        boolean flag = false;//能否装水标志
        for (int i = 0; i < height.length-1; i++) {
            if (i < height.length - 1 && flag == false && height[i + 1] >= height[i]) {
                continue;//一直递增且不在凹区间if (i > 0 && height[i] < height[i - 1])
            } else {//有下降区间
                left = i;//左边界
                flag=true;
                while (flag){//递减区间
                    if (i+1<height.length&&height[i + 1]<=height[i]) {
                        i++;
                    }
                    else break;
                }
                while (i + 1 < height.length && height[i + 1] >= height[i]) {//增区间
                    i++;
                }
                right = i;//右边界
                sum += helper(height, left, right);//雨水累积
                i--;
                flag = false;
            }
        }
        return sum;
    }
    public static int helper(int[] height, int left, int right) {
        int capacity = 0;
        int max=height[left]<height[right]?height[left]:height[right];
        for (int i = left; i <=right ; i++) {
            if (height[i]<max) {
                capacity += max - height[i];
            }
        }
        return capacity;
    }
}
