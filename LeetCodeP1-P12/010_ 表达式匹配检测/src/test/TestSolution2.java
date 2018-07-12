package test;

import com.util.Solution;
import com.util.Solution2;
import com.util.Solution3;

public class TestSolution2 {

	public static void main(String[] args) {
		boolean [][]a=new boolean[5][5];
		a[0][0]=true;
		a[1][1]=true;
		a[2][1]=a[1][0];
		a[3][1]=a[2][0];
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
}