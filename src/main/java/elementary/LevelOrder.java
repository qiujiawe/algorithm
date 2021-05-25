package elementary;

import model.TreeNode;

import java.util.*;

public class LevelOrder {
    /*
        二叉树的层序遍历
            给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
        示例：
            二叉树：[3,9,20,null,null,15,7],

                3
               / \
              9  20
                /  \
               15   7
            返回其层序遍历结果：

            [
              [3],
              [9,20],
              [15,7]
            ]
     */

    /*
        BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tempList = new ArrayList<>();
            while (size-- > 0) {
                TreeNode temp = deque.pop();
                tempList.add(temp.val);
                if (temp.left != null) {
                    deque.add(temp.left);
                }
                if (temp.right != null) {
                    deque.add(temp.right);
                }
            }
            result.add(tempList);
        }
        return result;
    }

    /*
        DFS
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // 记录每个节点层数
        Stack<Integer> numbers = new Stack<>();
        // 记录所有节点
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        numbers.add(0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int number = numbers.pop();
            if (number + 1 > result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(number).add(node.val);
            if (node.right != null) {
                nodes.add(node.right);
                numbers.add(number + 1);
            }
            if (node.left != null) {
                nodes.add(node.left);
                numbers.add(number + 1);
            }
        }
        return result;
    }
}
