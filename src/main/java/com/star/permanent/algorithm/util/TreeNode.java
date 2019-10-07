package com.star.permanent.algorithm.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = invert(root.left);
        root.left = invert(root.right);
        root.right = tmp;
        return root;
    }
}
