package elementary;

import model.ListNode;

public class RemoveNthFromEnd {
    /*
        删除链表的倒数第N个节点
            给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点

        示例 1：

            输入：head = [1,2,3,4,5], n = 2
            输出：[1,2,3,5]

        示例 2：

            输入：head = [1], n = 1
            输出：[]

        示例 3：

            输入：head = [1,2], n = 1
            输出：[1]
     */

    /*
        暴力解法
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        curr = head;
        int targetSub = size - n;
        if (targetSub == 0) {
            assert head != null;
            return head.next;
        }
        for (int i = 0; i < targetSub - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    /*
        双指针
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode last = null;
        while (fast != null) {
            fast = fast.next;
            last = slow;
            slow = slow.next;
        }
        if (head == slow) {
            assert head != null;
            return head.next;
        } else {
            last.next = last.next.next;
        }
        return head;
    }

}
