/**
 * @author zhaotian
 * @date 2018/7/9 11:02
 */
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//        示例:
//
//        给定 1->2->3->4, 你应该返回 2->1->4->3.
//
//        说明:
//
//        你的算法只能使用常数的额外空间。
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
public class P24 {
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
        ListNode res =swapPairs(listNode1);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode pre=helper;
        ListNode cur=head;
        while (cur!=null&&cur.next!=null){
            ListNode next=cur.next.next;
            cur.next.next=cur;
            pre.next=cur.next;
            if(next!=null&&next.next!=null){
                cur.next=next.next;
            }
            else
                cur.next=next;
            pre=cur;
            cur=next;
        }
        return helper.next;
    }
   static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

