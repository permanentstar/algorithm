package com.star.permanent.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    数组中的第K个最大元素
    在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
    Example 1:
    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
    Example 2:
    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
    Note:
    You may assume k is always valid, 1 ≤ k ≤ array's length.
    https://leetcode-cn.com/problems/kth-largest-element-in-an-array
* */
public class LC_215_Kth_Largest_Element_In_Array {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Queue<Integer> queue = new PriorityQueue<>(k); // 小顶堆
        for (int i=0;i<nums.length;++i) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
