package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.TreeNode;

/*
    将有序数组转换为二叉搜索树
    将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    Example:
    Given the sorted array: [-10,-3,0,5,9],
    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
          0
         / \
       -3   9
       /   /
     -10  5
    https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
* */
public class LC_108_Convert_Sorted_Array_To_Binary_Search_Tree {

    public static void main(String[] args) {

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    /*
    * [s,e]
    * */
    private static TreeNode sortedArrayToBST(int[] nums,int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + ((e-s) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,s,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,e);
        return root;
    }
}
