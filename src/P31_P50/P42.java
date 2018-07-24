package P31_P50;

/**
 * @author zhaotian
 * @date 2018/7/24 13:24
 */
//这种方法是基于动态规划的，基本思路就是维护一个长度为n的数组，
// 进行两次扫描，一次从左往右，一次从右往左。第一次扫描的时候
// 维护对于每一个bar左边最大的高度是多少，存入数组对应元素中，
// 第二次扫描的时候维护右边最大的高度，并且比较将左边和右边小
// 的最大高度（我们成为瓶颈）存入数组对应元素中。这样两遍扫描
// 之后就可以得到每一个bar能承受的最大水量，从而累加得出结果。
// 这个方法只需要两次扫描，所以时间复杂度是O(2*n)=O(n)。空间上
// 需要一个长度为n的数组，复杂度是O(n)。
public class P42 {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};//6
//        int[] height = {9,6,8,8,5,6,3};//3
        int[] height = {5,2,1,2,1,5};//14
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }
    //每一个bar能装的水取决于其左边和右边的最大高度（能达到的高度最多为较小的那个）
    public static int trap(int[] height){
        if (height == null || height.length <= 2) {
            return 0;
        }
        int res=0;
        int max=0;
        int[] container=new int[height.length];
        for (int i = 0; i <height.length ; i++) {//从左至右 每个bar对应左边最大高度
            container[i] = max;
            max=Math.max(max,height[i]);
        }
        max=0;
        for (int i = height.length-1; i >=0; i--) {
            container[i]=Math.min(max,container[i]);
            max=Math.max(max,height[i]);
            res+=container[i]-height[i]>0?container[i]-height[i]:0;
        }
        return res;
    }
//用两个指针从两端往中间扫，在当前窗口下，如果哪一侧的高度是小的，
// 那么从这里开始继续扫，如果比它还小的，肯定装水的瓶颈就是它了，
// 可以把装水量加入结果，如果遇到比它大的，立即停止，重新判断左右
// 窗口的大小情况，重复上面的步骤。这里能作为停下来判断的窗口，说
// 明肯定比前面的大了，所以目前肯定装不了水（不然前面会直接扫过去）
// 。这样当左右窗口相遇时，就可以结束了，因为每个元素的装水量都已经
// 记录过了。
    public static int trap2(int[] height){
        if (height == null || height.length <= 2) {
            return 0;
        }
        int l = 0;//左指针
        int r = height.length-1;//右指针
        int res = 0;
        while (l<r){
            int min=Math.min(height[l],height[r]);//两边较小
            if (height[l]==min){//较小的在左边
                l++;//右移
                while (l<r&&height[l]<min){
                    res+=min-height[l];
                    l++;
                }
            }
            else {//较小的在右边
                r--;//左移
                while (l<r&&height[r]<min){
                    res+=min-height[r];
                    r--;
                }
            }
        }
        return res;
    }
}
