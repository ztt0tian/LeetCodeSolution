package test;

import com.util.Solution;
import com.util.Solution2;
import com.util.Solution3;

public class TestSolution {

	public static void main(String[] args) {
		//System.out.println(Integer.MIN_VALUE+"-----"+Integer.MAX_VALUE);
		String s1="ab";
		String s2="*.b";		 
		System.out.println(new Solution().isMatch(s1, s2));
		System.out.println(new Solution2().isMatch(s1, s2));
		System.out.println(new Solution3().isMatch(s1, s2));
		}
	}
