package elementary;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth {
    /*
        二叉树的最大深度
            给定一个二叉树，找出其最大深度。

            二叉树的深度为根节点到最远叶子节点的最长路径上的节点数

            说明: 叶子节点是指没有子节点的节点
     */

    /*
        递归
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    /*
        BFS
            一层层遍历
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        int count = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode temp = deque.pop();
                if (temp.left != null) deque.add(temp.left);
                if (temp.right != null) deque.add(temp.right);
            }
            count++;
        }
        return count;
    }
}
