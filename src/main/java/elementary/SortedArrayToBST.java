package elementary;

import model.TreeNode;

public class SortedArrayToBST {
    /*
        给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树

        高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树
     */

    /*
        递归
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        int len = nums.length;
        root.val = nums[len / 2];
        sortedArrayToBSTHelper(root, nums, 0, len / 2 - 1);
        sortedArrayToBSTHelper(root, nums, len / 2 + 1, len - 1);
        return root;
    }

    public void sortedArrayToBSTHelper(TreeNode root, int[] nums, int left, int right) {
        if (left > right) return;
        int len = right - left + 1;
        int sub = left + len / 2;
        if (root.val > nums[sub]) {
            root.left = new TreeNode();
            root.left.val = nums[sub];
            sortedArrayToBSTHelper(root.left, nums, left, sub - 1);
            sortedArrayToBSTHelper(root.left, nums, sub + 1, right);
        } else {
            root.right = new TreeNode();
            root.right.val = nums[sub];
            sortedArrayToBSTHelper(root.right, nums, left, sub - 1);
            sortedArrayToBSTHelper(root.right, nums, sub + 1, right);
        }
    }

}
