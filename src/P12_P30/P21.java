package P12_P30;

/**
 * @author zhaotian
 * @date 2018/7/3 16:06
 */
//利用递归的思想解决，大大减少了代码量
public class P21 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=null;
        ListNode m1=new ListNode(1);
        ListNode m2=new ListNode(3);
        ListNode m3=new ListNode(4);
        m1.next=m2;
        m2.next=m3;
        m3.next=null;
        ListNode res=mergeTwoLists(n1,m1);
        while (res!=null){
            System.out.print(res.val+"->");
            res=res.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=null;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<=l2.val){
            head=l1;
            head.next=mergeTwoLists(l1.next,l2);
        }
        if(l1.val>l2.val){
            head=l2;
            head.next=mergeTwoLists(l1,l2.next);
        }
        return head;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

