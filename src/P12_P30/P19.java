package P12_P30;

/**
 * @author zhaotian
 * @date 2018/6/28 14:16
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */

public class P19 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        ListNode res = removeNthFromEnd(listNode1, 5);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;//p1,p2均向右移动
        for (int i = 1; i <= n; i++) {//让P2先跟P1相差n+1
            p2 = p2.next;
        }
        if (p2 == null) {//n等于总节点数
            return head.next;
        }
        //此时p1 p2 同步 往右移动直至p2移动到尾指针
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        //此时p1 p2 间距不变，且p2走到头了 p1就是倒数（间距值《n+1》）个节点
        //我们要删除倒数第n个节点
        p1.next = p1.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
