package P12_P30;

/**
 * @author zhaotian
 * @date 2018/7/12 10:23
 */
//给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
//
//        k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
//
//        示例 :
//
//        给定这个链表：1->2->3->4->5
//
//        当 k = 2 时，应当返回: 2->1->4->3->5
//
//        当 k = 3 时，应当返回: 3->2->1->4->5
//
//        说明 :
//
//        你的算法只能使用常数的额外空间。
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。


public class P25 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next=null;

        ListNode res=reverseKGroup(listNode1,3);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode helper=new ListNode(0);
        ListNode begin=helper;
        ListNode current=head;
        helper.next=head;
        int count=0;
        while (current!=null){
            count++;
            if(count%k==0){
                begin=reverseList(begin,current.next);
                current=begin.next;
            }
            else {
                current=current.next;
            }
        }
        return helper.next;
    }
    public static ListNode reverseList(ListNode begin,ListNode end ){
        ListNode last=begin.next;
        ListNode cur=last.next;
        while (cur!=end){
            last.next=cur.next;
            cur.next=begin.next;
            begin.next=cur;
            cur=last.next;
        }
        return last;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
