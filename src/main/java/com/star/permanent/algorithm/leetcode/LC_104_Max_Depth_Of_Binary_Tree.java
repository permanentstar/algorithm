package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

/*
    二叉树的最大深度
    给定一个二叉树，找出其最大深度。
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    说明: 叶子节点是指没有子节点的节点。
    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    Note: A leaf is a node with no children.
    Example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its depth = 3.
    https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
* */
public class LC_104_Max_Depth_Of_Binary_Tree {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        return maxChildDepth(root,0);
    }
    private static int maxChildDepth(TreeNode child,int parentDepth) {
        if (child == null){
            return parentDepth;
        }
        return Math.max(maxChildDepth(child.left, parentDepth+1),maxChildDepth(child.right,parentDepth+1));
    }
}
