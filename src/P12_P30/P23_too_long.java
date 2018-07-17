package P12_P30;

/**
 * @author zhaotian
 * @date 2018/7/5 14:54
 */
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//        示例:
//
//        输入:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        输出: 1->1->2->3->4->4->5->6
//    利用之前的两个链表排序来依次求解
public class P23_too_long {
    public ListNode mergeKLists(ListNode[] lists) {
        int size=lists.length;
        if (size<=0){
            return null;
        }
        int i=0;
        while (i<size-1){
            lists[i+1]=mergeTwoLists(lists[i],lists[i+1]);
            i++;
        }
        return lists[size-1];
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
