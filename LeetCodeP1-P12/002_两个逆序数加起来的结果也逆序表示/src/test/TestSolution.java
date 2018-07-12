package test;

import com.util.ListNode;
import com.util.Solution;

public class TestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode  l1=new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		ListNode  l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		ListNode result=new Solution().addTwoNumbers(l1, l2);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
			
		}
	}
}
