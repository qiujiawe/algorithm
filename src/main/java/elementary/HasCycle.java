package elementary;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    /*
        环形链表
            给定一个链表，判断链表中是否有环。

            如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

            如果链表中存在环，则返回 true 。 否则，返回 false
     */

    /*
        快慢指针
            慢指针一次移动一位,快指针一次移动两位,若快慢指针相遇则返回true
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head,
                slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /*
        Set集合
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /*
        指向自己
-----------------------------
        head = 1
            1 -> 2 -> 3
                 ↑    ↓
                 ↑ <- ↓
-----------------------------
        让 1 指向自己
            1    2 -> 3
                 ↑    ↓
                 ↑ <- ↓
        head = 2
-----------------------------
        让 2 指向自己
            1    2    3
                 ↑    ↓
                 ↑ <- ↓
        head = 3
-----------------------------
        让 3 指向自己
            1    2    3
        head = 2
        此时会出现 head == head.next 的情况,因为之前的步骤让 2 指向了自己
        return true

     */
    public boolean hasCycle2(ListNode head) {
        while (head != null) {
            if (head == head.next) return true;
            ListNode temp = head.next;
            head.next = head;
            head = temp;
        }
        return false;
    }

    /*
        翻转链表后比较首节点
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) return false;
        return head == reversal(head);
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
