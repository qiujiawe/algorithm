package elementary;

import model.TreeNode;

import java.util.*;

public class IsSymmetric {
    /*
        对称二叉树
            给定一个二叉树，检查它是否是镜像对称的。

        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

            1
           / \
          2   2
         / \ / \
        3  4 4  3

        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

            1
           / \
          2   2
           \   \
           3    3

     */

    /*
        暴力解法
            一行行遍历,然后判断是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode temp = deque.pop();
                if (temp.left != null) {
                    deque.add(temp.left);
                    list.add(temp.left.val);
                } else {
                    list.add(null);
                }
                if (temp.right != null) {
                    deque.add(temp.right);
                    list.add(temp.right.val);
                } else {
                    list.add(null);
                }
            }
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                if (!Objects.equals(list.get(left++), list.get(right--))) {
                    return false;
                }
            }
            list.clear();
        }
        return true;
    }

    /*
        两个两个比
            递归
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
    }

    /*
        两个两个比
            非递归
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pop(),
                    right = deque.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            deque.add(left.left);
            deque.add(right.right);
            deque.add(left.right);
            deque.add(right.left);
        }
        return true;
    }


}
