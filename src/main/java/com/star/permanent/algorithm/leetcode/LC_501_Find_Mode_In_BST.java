package com.star.permanent.algorithm.leetcode;

/*
    二叉搜索树中的众数
    给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
    假定 BST 有如下定义：
    结点左子树中所含结点的值小于等于当前结点的值
    结点右子树中所含结点的值大于等于当前结点的值
    左子树和右子树都是二叉搜索树
    Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
    Assume a BST is defined as follows:
    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.
    For example:
    Given BST [1,null,2,2],
       1
        \
         2
        /
       2
    return [2].
    Note: If a tree has more than one mode, you can return them in any order.
    Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
    https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
* */

import com.star.permanent.algorithm.util.TreeNode;

import java.util.*;

public class LC_501_Find_Mode_In_BST {
    public static void main(String[] args ) {
        TreeNode root = new TreeNode(2147483647);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(2);
        findMode(root);
    }

    /*
    * bst的中序遍历为升序 类似有序数组顺序遍历
    * */
    static int maxCnt = 0;
    static Integer pre = null;
    static int acc = 0;
    public static int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        Set<Integer> rs = new HashSet<>();
        inOrder(root, rs);
        if (acc > maxCnt) {
            rs.clear();
            rs.add(pre);
            maxCnt = acc;
        } else if (acc == maxCnt) {
            rs.add(pre);
        }
        int[] ar = new int[rs.size()];
        Iterator<Integer> it = rs.iterator();
        int i = 0;
        while (it.hasNext()) {
            ar[i++] = it.next();
        }
        return ar;
    }
    private static void inOrder(TreeNode node, Set<Integer> rs) {
        if (node == null) return;
        inOrder(node.left, rs);
        if (pre != null && node.val == pre) {
            ++acc;
        } else {
            if (acc > maxCnt) {
                rs.clear();
                rs.add(pre);
                maxCnt = acc;
            } else if (acc == maxCnt) {
                rs.add(pre);
            }
            acc = 1;
            pre = node.val;
        }
        inOrder(node.right, rs);
    }

}
