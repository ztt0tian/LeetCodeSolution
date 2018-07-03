/**
 * @author zhaotian
 * @date 2018/6/30 14:27
 */
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//        示例：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4
//

public class P21_too_long {
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
        ListNode res;
        ListNode p=null;
        res=p;
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        while (l1!=null||l2!=null){
            if(l1!=null&&l2!=null&&l1.val<=l2.val){
                if(res==null){
                    res=new ListNode(l1.val);
                    res.next=null;
                    p=res;
                }
                else {
                    ListNode temp=new ListNode(l1.val);
                    temp.next=null;
                    p.next=temp;
                    p=temp;
                }
                l1=l1.next;
            }
            else if(l1!=null&&l2!=null&&l1.val>l2.val){
                if(res==null){
                    res=new ListNode(l2.val);
                    res.next=null;
                    p=res;
                    res=p;
                }
                else {
                    ListNode temp=new ListNode(l2.val);
                    temp.next=null;
                    p.next=temp;
                    p=temp;
                }
                l2=l2.next;
            }
            else if(l1==null){
                p.next=l2;
                l2=null;
            }
            else {
                p.next=l1;
                l1=null;
            }
        }
        return res;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
