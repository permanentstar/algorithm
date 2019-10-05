package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.Node;

import java.util.*;

/*
    N叉树的层序遍历
    给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
    Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    For example, given a 3-ary tree:
    We should return its level order traversal:
    [
         [1],
         [3,2,4],
         [5,6]
    ]
    Note:
    The depth of the tree is at most 1000.
    The total number of nodes is at most 5000.
    https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
* */
public class LC_429_N_Array_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.emptyList();
        Queue<List<Node>> queue = new LinkedList<>();
        queue.offer(Collections.singletonList(root));
        List<List<Integer>> rs = new LinkedList<>();
        List<Node> nodes;
        while (!queue.isEmpty()) {
            nodes = queue.poll();
            List<Integer> l = new ArrayList<>(nodes.size());
            rs.add(l);
            List<Node> next = new ArrayList<>();
            for(Node n : nodes) {
                l.add(n.val);
                if (n.children != null) {
                    next.addAll(n.children);
                }
            }
            if (!next.isEmpty()) {
                queue.offer(next);
            }
        }
        return rs;
    }
}
