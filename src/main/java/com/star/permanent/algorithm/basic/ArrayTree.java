package com.star.permanent.algorithm.basic;
/*
* 完全二叉树
* */
public class ArrayTree {
    private static int[] tree = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    public static void main(String[] args) {
        System.out.println("=== start preOrder ===");
        preOrder(1);
        System.out.println("=== start postOrder ===");
        postOrder(1);
    }

    private static void preOrder(int index) {
        if (index >= tree.length) return;
        int left = index << 1;
        int right = left + 1;
        System.out.println(tree[index]);
        preOrder(left);
        preOrder(right);
    }

    private static void postOrder(int index) {
        if (index >= tree.length) return;
        int left = index << 1;
        int right = left + 1;
        postOrder(left);
        postOrder(right);
        System.out.println(tree[index]);
    }
}
