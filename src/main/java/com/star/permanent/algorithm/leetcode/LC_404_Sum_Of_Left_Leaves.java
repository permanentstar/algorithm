package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

/*
    左叶子之和
    计算给定二叉树的所有左叶子之和。
    Find the sum of all left leaves in a given binary tree.
    Example:
        3
       / \
      9  20
        /  \
       15   7
    There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
    https://leetcode-cn.com/problems/sum-of-left-leaves
* */
public class LC_404_Sum_Of_Left_Leaves {
    public static void main(String[] args) {

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root,false);
    }

    private static int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return isLeft ? node.val: 0;
        }
        return sumOfLeftLeaves(node.left,true) + sumOfLeftLeaves(node.right, false);
    }
}
