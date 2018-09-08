package P31_P50;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46 {
    public static void main(String[] args){
        int[] array=new int[]{1,2,3};
        System.out.println(permute(array));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> nums_list = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            nums_list.add(nums[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        permute_helper(nums_list, 0, res);
        return res;
    }

    public static void permute_helper(List<Integer> nums_list, int start, List<List<Integer>> res) {
        if (start == nums_list.size()) {//最后一位只有一种可能 不能交换
            res.add(new ArrayList<>(nums_list));//直接add(nums_list) 顺序没有发生改变
        }
        else
            for (int i = start; i <nums_list.size() ; i++) {
                swap_list(nums_list, start, i);//固定当前位置，进行下一位全排列
                permute_helper(nums_list, start + 1, res);
                swap_list(nums_list,start,i);//还原
            }
    }

    //s表示，从array[start]后的数据进行全排列
    public static void permute2(int[] array,int start){
        List<int[]> res = Arrays.asList(array);
        if(start==array.length){  // 输出
            System.out.println(Arrays.toString(array));
        }
        else
            for(int i=start;i<array.length;++i){
                swap(array,start,i);  // 相当于固定当前位置，在进行下一位的排列。
                permute2(array,start+1);  //交换后，再进行全排列算法
                swap(array,start,i);  //还原成原来的数组，便于下一次的全排列
            }
    }
    private static void swap(int[] array,int s,int i){
        int t=array[s];
        array[s]=array[i];
        array[i]=t;
    }
    private static void swap_list(List<Integer> list, int s, int i){
        int t = list.get(s);
        list.set(s, list.get(i));
        list.set(i, t);
    }
}