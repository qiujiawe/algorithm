package elementary;

import model.ListNode;

public class IsPalindrome2 {
    /*
        回文链表
            请判断一个链表是否为回文链表

        示例 1:

            输入: 1->2
            输出: false

        示例 2:

            输入: 1->2->2->1
            输出: true
     */

    /*
        反转后半部分,然后比较
     */
    public boolean isPalindrome1(ListNode head) {
        // 慢,慢指针最终会指向要反转的部分的首节点
        ListNode slow = head;
        // 快
        ListNode fast = head;
        /*
                         ↓
                1 2 3 4 null
                    ↓
                1 2 [3 4]

                        ↓
                1 2 3 4 5 null
                    ↓
                1 2 3 [4 5]
         */
        while (!(fast == null || fast.next == null)) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reversal(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }


    public ListNode reversal(ListNode head) {
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














