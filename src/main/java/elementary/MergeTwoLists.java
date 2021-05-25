package elementary;

import model.ListNode;

public class MergeTwoLists {
    /*
        合并两个有序链表
            将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
     */

    /*
        暴力解法
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prePrev = new ListNode(-1),
                pre = prePrev;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return prePrev.next;
    }

}
