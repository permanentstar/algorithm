package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

/*
    相同的树
    给定两个二叉树，编写一个函数来检验它们是否相同。
    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    Given two binary trees, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
    Example 1:
    Input:     1         1
              / \       / \
             2   3     2   3
            [1,2,3],   [1,2,3]
    Output: true
    Example 2:
    Input:     1         1
              /           \
             2             2
            [1,2],     [1,null,2]
    Output: false
    Example 3:
    Input:     1         1
              / \       / \
             2   1     1   2
            [1,2,1],   [1,1,2]
    Output: false
    https://leetcode-cn.com/problems/same-tree
* */
public class LC_100_Same_Tree {

    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
