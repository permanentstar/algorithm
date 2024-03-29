package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

/*
    路径总和
    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    说明: 叶子节点是指没有子节点的节点。
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    Note: A leaf is a node with no children.
    Example:
    Given the below binary tree and sum = 22,
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    https://leetcode-cn.com/problems/path-sum
* */
public class LC_112_Path_Sum {

    public static void main(String[] args) {

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root,sum,0);
    }

    private static boolean pathSum(TreeNode node, int sum, int acc) {
        if (node == null) return false;
        acc += node.val;
        if (acc == sum && node.left == null && node.right == null) return true;
        return pathSum(node.left, sum,acc) || pathSum(node.right,sum,acc);
    }
}
