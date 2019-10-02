package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

import java.util.*;

/*
    二叉树的层次遍历 II
    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
    https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
* */
public class LC_107_Binary_Tree_Level_Order_Traversal_II {
    static TreeNode root = new TreeNode(3);
    static {
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }
    public static void main(String[] args) {
        List<List<Integer>> rs = levelOrderBottom(root);
        System.out.println(rs.size());
    }

    /*
    * 层次遍历 不论正向 反向 都需要借助中间队列或栈， 正向借助队列， 逆向借助栈
    * */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return Collections.emptyList();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        stack.push(Collections.singletonList(root.val));
        queue.offer(Collections.singletonList(root));
        List<TreeNode> nodes,children;
        List<Integer> vals;
        List<List<Integer>> rs = new ArrayList<>();
        while (!queue.isEmpty()) {
            nodes = queue.poll();
            children = new ArrayList<>();
            vals = new ArrayList<>();
            for(TreeNode n: nodes) {
                if (n.left != null) {
                    children.add(n.left);
                    vals.add(n.left.val);
                }
                if (n.right != null) {
                    children.add(n.right);
                    vals.add(n.right.val);
                }
            }
            if (!children.isEmpty()) {
                queue.offer(children);
                stack.push(vals);
            }

        }
        while (!stack.isEmpty()) {
            rs.add(stack.pop());
        }
        return rs;
    }
}
