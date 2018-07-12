package com.util;

public class Solution {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	if(l1==null){
		return l2;
	}
	if(l2==null){
		return l1;
	}
	int flag=0;
	ListNode newNode=new ListNode(-1);
	ListNode l3=newNode;
	while(l1!=null||l2!=null){
		if(l1!=null){
			flag+=l1.val;
			l1=l1.next;
		}
		if(l2!=null){
			flag+=l2.val;
			l2=l2.next;
		}
		l3.next=new ListNode(flag%10);
		flag=flag/10;
		l3=l3.next;
	}
	if(flag==1){
		l3.next=new ListNode(1);
	}
	return newNode.next;
	
    }
}
