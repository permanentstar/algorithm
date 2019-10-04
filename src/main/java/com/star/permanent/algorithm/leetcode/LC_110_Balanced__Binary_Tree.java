package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

/*
    平衡二叉树
    给定一个二叉树，判断它是否是高度平衡的二叉树。
    本题中，一棵高度平衡二叉树定义为：
    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    Given a binary tree, determine if it is height-balanced.
    For this problem, a height-balanced binary tree is defined as:
    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    Example 1:
    Given the following tree [3,9,20,null,null,15,7]:
        3
       / \
      9  20
        /  \
       15   7
    Return true.
    Example 2:
    Given the following tree [1,2,2,3,3,null,null,4,4]:
           1
          / \
         2   2
        / \
       3   3
      / \
     4   4
    Return false.
    https://leetcode-cn.com/problems/balanced-binary-tree
* */
public class LC_110_Balanced__Binary_Tree {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        try {
            height(root);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left-right) > 1) {
            throw new RuntimeException();
        }
        return Math.max(left,right) + 1;
    }
}
