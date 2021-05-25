package elementary;

import model.ListNode;

import java.util.Stack;

public class ReverseList {
    /*
        反转链表
            给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
     */

    /*
        递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    /*
        栈
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        ListNode result = stack.pop();
        ListNode temp = result;
        while (!stack.empty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return result;
    }

    /*
        暴力

                                    pre
                                          head
                                          next
                                     ↓     ↓
        null <- 1  <-  2  <-  3  <-  4 -> null

     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
