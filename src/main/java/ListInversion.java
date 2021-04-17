import model.Node;

import java.util.Objects;

public class ListInversion {
    /*
        链表反转

        例子:
            输入: 1 -> 2 -> 3 -> 4 -> 5
            返回: 5 -> 4 -> 3 -> 2 -> 1

        思路1:
            从前往后逐个维护节点的next

            问题: 修改前面节点的next会导致后面节点丢失

            实现后的总结: 从前往后维护节点的next会导致后面的节点丢失， 用变量来储存丢失的节点，然后逐个维护next

         思路2:
            从末尾的节点开始反转，这样不会丢失节点

            问题: 节点多会出现栈内存溢出

            实现后的总结: 递归可以让我从末尾的节点开始反转

     */
    // 创建链表
    public static Node createNodeList(int num) {
        Node start = null;
        Node previous = null;
        for (int i = 1; i < num; i++) {
            if (i == 1) {
                start = new Node(null, i);
                previous = start;
                continue;
            }
            Node temp = new Node(null, i);
            previous.setNext(temp);
            previous = temp;
        }
        return start;
    }
    // 思路1的实现
    public static Node ideaOne(Node node) {
        // 初始化变量
        Node prev,
                curr = node,
                next = node.getNext();
        curr.setNext(null);
        while (!Objects.isNull(next)) {
            prev = curr;
            curr = next;
            next = curr.getNext();
            curr.setNext(prev);
        }
        return curr;
    }
    // 思路2的实现
    private static Node ideaTwo(Node node){
        Node result;
        if (!Objects.isNull(node.getNext().getNext())) {
            // 不是倒数第二个
            result = ideaTwo(node.getNext());
            node.getNext().setNext(node);
        } else {
            // 是倒数第二个
            result = node.getNext();
            result.setNext(node);
        }
        node.setNext(null);
        return result;
    }
    public static void main(String[] args) {
        Node node = createNodeList(10);
        //node = ideaOne(node);
        node = ideaTwo(node);
        System.out.println(node);
    }

}
