package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

/*
    二叉搜索树的最近公共祖先
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
    Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
    Example 1:
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
    Explanation: The LCA of nodes 2 and 8 is 6.
    Example 2:
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    Output: 2
    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
    Note:
    All of the nodes' values will be unique.
    p and q are different and both values will exist in the BST.
    https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
* */
public class LC_235_Lowest_Common_Ancestor_Of_Binary_Tree {
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val || p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val) {
            return root;
        }
        if (p.val <= root.val) {
            return lowestCommonAncestor(root.left,p,q);
        } else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}
