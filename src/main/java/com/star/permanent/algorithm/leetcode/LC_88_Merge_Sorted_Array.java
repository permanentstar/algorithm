package com.star.permanent.algorithm.leetcode;
/*
    给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    Note:
    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
    Example:
    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3
    Output: [1,2,2,3,5,6]
    https://leetcode-cn.com/problems/merge-sorted-array
* */
public class LC_88_Merge_Sorted_Array {
    static int[] nums1 = {1,2,3,0,0,0};
    static int[] nums2 = {2,5,6};
    public static void main(String[] args) {
        merge(nums1, 3,nums2,3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }

    /*
    * nums1.size >= m + n
    * nums1 asc, nums2 asc
    * 可以使用desc方式 从nums1的 m+n-1 位置倒序往前排，依次比较num1[m-1] num2[n-1], ...
    * */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int revertLen = m+n;
        int v1,v2;
        while (m>0 && n>0) {
            v1 = nums1[m-1];
            v2 = nums2[n-1];
            if (v1 > v2) {
                nums1[--revertLen] = v1;
                --m;
            } else {
                nums1[--revertLen] = v2;
                --n;
            }
        }
        if (m == 0) {  // num2 剩余补齐
            while (n > 0) {
                nums1[--revertLen] = nums2[--n];
            }
        } else {  // num1 即使剩余也不需要再移动(位置不变)
            /*while (m > 0) {
                nums1[--revertLen] = nums1[--m];
            }*/
        }
    }
}
