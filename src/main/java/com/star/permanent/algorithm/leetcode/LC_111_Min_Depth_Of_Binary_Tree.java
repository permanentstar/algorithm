package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

import java.util.*;

/*
    二叉树的最小深度
    给定一个二叉树，找出其最小深度。
    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    说明: 叶子节点是指没有子节点的节点。
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    Note: A leaf is a node with no children.
    Example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its minimum depth = 2.
    https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
* */
public class LC_111_Min_Depth_Of_Binary_Tree {

    public static void main(String[] args) {

    }
    /*
    * BFS
    * */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.offer(Collections.singletonList(root));
        List<TreeNode> nodes;
        int minDepth = 0;
        while (!queue.isEmpty()) {
            nodes = queue.poll();
            ++ minDepth;
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode n: nodes) {
                if (n.left == null && n.right == null) {
                    return minDepth;
                }
                if (n.left != null) next.add(n.left);
                if (n.right != null) next.add(n.right);
            }
            queue.offer(next);
        }
        throw new RuntimeException("can not be reached");
    }

    /*
    * recursive
    * */
    public static int minDepthRecur(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepthRecur(root.right) + 1;
        if (root.right == null) return minDepthRecur(root.left) + 1;
        return Math.min(minDepthRecur(root.left),minDepthRecur(root.right)) + 1;
    }

}
