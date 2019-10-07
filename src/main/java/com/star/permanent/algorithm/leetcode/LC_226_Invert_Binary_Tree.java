package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

/*
    翻转二叉树
    翻转一棵二叉树。
    示例：
    输入：
         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    输出：
         4
       /   \
      7     2
     / \   / \
    9   6 3   1
    https://leetcode-cn.com/problems/invert-binary-tree
* */
public class LC_226_Invert_Binary_Tree {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        return TreeNode.invert(root);
    }
}
