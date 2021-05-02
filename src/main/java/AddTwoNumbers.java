import model.ListNode;

public class AddTwoNumbers {
    /*
        两数相加

            给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字
            请你将两个数相加，并以相同形式返回一个表示和的链表
            你可以假设除了数字 0 之外，这两个数都不会以 0开头


            示例 1：

                输入：l1 = [2,4,3], l2 = [5,6,4]
                输出：[7,0,8]
                解释：342 + 465 = 807

            示例 2：

                输入：l1 = [0], l2 = [0]
                输出：[0]

            示例 3：

                输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
                输出：[8,9,9,9,0,0,0,1]

     */

    /*
        小学数学加法:
            2 4 3
         +  5 6 4
         -----------
            7 0 7
             1
         -----------
            8 0 7
        用变量记录是否进位 和 下一个节点即可,剩下的用节点的val加就完事了
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 用于记录是否进位
        boolean carry = false;
        // l1,l2一开始肯定有值,先初始化head
        int s1 = l1.val + l2.val;
        if (s1 >= 10) {
            carry = true;
            s1 = s1 % 10;
        }
        ListNode head = new ListNode(s1);
        // 创建三个变量来做循环
        ListNode curr = head;
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;
        while (n1 != null || n2 != null || carry) {
            int v1 = n1 == null ? 0 : n1.val;
            int v2 = n2 == null ? 0 : n2.val;
            s1 = carry ? v1 + v2 + 1 : v1 + v2;
            if (s1 >= 10) {
                s1 = s1 % 10;
                carry = true;
            } else {
                carry = false;
            }
            ListNode temp = new ListNode(s1);
            curr.next = temp;
            curr = temp;
            // 维护变量
            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
        }
        return head;
    }

    /*
        测试
     */
    public static void main(String[] args) {
        ListNode temp1 = new ListNode(3,null);
        ListNode temp2 = new ListNode(4,temp1);
        ListNode temp3 = new ListNode(4,null);
        ListNode temp4 = new ListNode(6,temp3);
        ListNode l1 = new ListNode(2,temp2);
        ListNode l2 = new ListNode(5,temp4);
        ListNode result = addTwoNumbers(l1,l2);
        System.out.println(result);
    }

}
