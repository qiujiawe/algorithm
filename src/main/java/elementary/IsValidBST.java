package elementary;

import model.TreeNode;

import java.util.Stack;

public class IsValidBST {
    /*
        验证二叉搜索树
            给定一个二叉树，判断其是否是一个有效的二叉搜索树。

            假设一个二叉搜索树具有如下特征：

            节点的左子树只包含小于当前节点的数。
            节点的右子树只包含大于当前节点的数。
            所有左子树和右子树自身必须也是二叉搜索树。

        示例 1:

        输入:
            2
           / \
          1   3
        输出: true

        示例 2:

        输入:
            5
           / \
          1   4
             / \
            3   6
        输出: false
        解释: 输入为: [5,1,4,null,null,3,6]。
             根节点的值为 5 ，但是其右子节点值为 4 。
     */

    /*
        递归
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    /*
        非递归中序遍历
            如果二叉树是有效的,中序遍历出来的元素是有序的
     */
    public boolean isValidBST1(TreeNode root) {
        long temp = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= temp) return false;
            temp = root.val;
            root = root.right;
        }
        return true;
    }

    /*
        递归中序遍历
     */
    public long prev = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (prev >= root.val) return false;
        prev = root.val;
        return isValidBST(root.right);
    }
}
