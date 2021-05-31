package elementary;

public class MinStack {
    /*
        设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     */

    /*
        大佬解法
     */
    static class ListNode {
        private final ListNode next;
        private final int val;
        private final int min;

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private ListNode head = null;

    public void push(int val) {
        head = head == null ? new ListNode(val,val,null) : new ListNode(val,Math.min(head.min,val),head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }



    /*
        暴力解法
     */
//    private ListNode minNode = null;
//    private final Stack<Integer> stack = new Stack<>();
//
//    public MinStack() {
//
//    }
//
//    public void push(int val) {
//        stack.push(val);
//        insertion(val);
//    }
//
//    private void insertion(int val) {
//        ListNode node = minNode,
//                last = null;
//        while (node != null && val > node.val) {
//            last = node;
//            node = node.next;
//        }
//        if (node == minNode) {
//            ListNode temp = minNode;
//            minNode = new ListNode(val);
//            minNode.next = temp;
//        } else {
//            ListNode temp = last.next;
//            last.next = new ListNode(val);
//            last.next.next = temp;
//        }
//    }
//
//    public void pop() {
//       Integer val = stack.pop();
//       delete(val);
//    }
//
//    private void delete(Integer val) {
//        ListNode node = minNode,
//                last = null;
//        while (val != node.val) {
//            last = node;
//            node = node.next;
//        }
//        if (node == minNode) {
//            minNode = minNode.next;
//        } else {
//            last.next = last.next.next;
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return minNode.val;
//    }
}
