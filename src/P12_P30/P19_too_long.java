package P12_P30;

/**
 * @author zhaotian
 * @date 2018/6/28 14:16
 *
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */

public class P19_too_long {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
//        ListNode listNode3=new ListNode(3);
//        ListNode listNode4=new ListNode(4);
//        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=null;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
//        listNode5.next=null;
        ListNode res=removeNthFromEnd(listNode1,1);
        while (res!=null){
            System.out.print(res.val+"->");
            res=res.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        int cout=0;
        int left=0;
        while (p!=null){
            cout++;//边遍历边统计总节点数
            if(left<n){
                left++;
            }
//            if(left==n){//正数第n个节点
//                before_lp=before;///保存前置节点
//                lp=p;//保存这个节点
//            }
            p=p.next;
        }
        if(cout==n){
            return head.next;
        }
        if(2*left==cout){//中间 正数倒数相差一个位置
            p=head;
            head=p;
            while (left>1){
                p=p.next;
                left--;
            }
            p.next=p.next.next;
            return head;
        }
        if(2*left==cout+1){//中间 正数为同一个位置
            p=head;
            head.next=p.next;
            System.out.println(left);
            while (left>2){
                p=p.next;
                left--;
            }
            p.next=p.next.next;
            return head;
        }
        else{//一般情况
            int z_index=cout-n+1;//正向数间距
            p=head;
            head.next=p.next;
            while (z_index>2){
                p=p.next;
                z_index--;
            }
            p.next=p.next.next;
            return head;
        }
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
