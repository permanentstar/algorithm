package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    二叉树的所有路径
    给定一个二叉树，返回所有从根节点到叶子节点的路径。
    Given a binary tree, return all root-to-leaf paths.
    Note: A leaf is a node with no children.
    Example:
    Input:
       1
     /   \
    2     3
     \
      5
    Output: ["1->2->5", "1->3"]
    Explanation: All root-to-leaf paths are: 1->2->5, 1->3
    https://leetcode-cn.com/problems/binary-tree-paths
* */
public class LC_257_Binary_Tree_Path {

    public static void main(String[] args) {

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();
        if (root.left == null && root.right == null) {
            return Collections.singletonList(""+root.val);
        }
        List<String> curr = new ArrayList<>();
        if (root.left != null) {
            for(String s: binaryTreePaths(root.left)) {
                curr.add(root.val + "->" +s);
            }
        }
        if (root.right != null) {
            for(String s: binaryTreePaths(root.right)) {
                curr.add(root.val+ "->" +s);
            }
        }
        return curr;
    }
}
