package P12_P30;

/**
 * @author zhaotian
 * @date 2018/7/9 10:50
 */
public class P23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int size=lists.length;
        if (size<=0){
            return null;
        }
        return work(lists,0,size-1);
    }
    //归并排序思想
    public ListNode work(ListNode[] listNodes,int left,int right) {
        int mid=(left+right)/2;
        if(left<right) {
            ListNode l1=work(listNodes,left,mid);
            ListNode l2=work(listNodes,mid+1,right);
            return mergeTwoLists(l1,l2);
        }
        return listNodes[left];
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
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
