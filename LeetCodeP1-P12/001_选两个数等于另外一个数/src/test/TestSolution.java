package test;

import com.util.Solution;

public class TestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={3,7,11,15};
		int target=9;
		int[] jieguo=new Solution().twoSum(nums, target);
		if(jieguo!=null){
		for(int i=0; i<jieguo.length;i++){
			System.out.println(jieguo[i]);
		}
		}
		else{
			System.out.println("meiyou");
		}
		//System.out.println(Solution.twoSum(nums, target).toString());
	
	}
}
