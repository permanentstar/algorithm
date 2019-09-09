package com.star.permanent.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
        给定两个数组，编写一个函数来计算它们的交集。
        Given two arrays, write a function to compute their intersection.
        Example 1:
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]
        Example 2:
        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [4,9]
        Note:
        Each element in the result should appear as many times as it shows in both arrays.
        The result can be in any order.
        Follow up:

        What if the given array is already sorted? How would you optimize your algorithm?
        What if nums1's size is small compared to nums2's size? Which algorithm is better?
        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

        https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
*/
public class LC_350_Intersection_of_Two_Arrays_II {
    private static int[] nums1 = {1,2,2,1};
    private static int[] nums2 = {2,2};
    public static void main(String[] args) {
        int[] is = intersect(nums1, nums2);
        for(int i = 0;i<is.length;++i) {
            System.out.println(is[i]);
        }
    }
    /*
    * 方法类似 349::2
    * */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int n1,n2,i1 = 0,i2 = 0;
        List<Integer> rs = new ArrayList<>();
        while (i1 < l1 && i2< l2) {
            n1 = nums1[i1];
            n2 = nums2[i2];
            if(n1 == n2) {
                rs.add(n1);
                ++i1;
                ++i2;
            }else if (n1 > n2) {
                ++i2;
            } else {
                ++i1;
            }
        }
        int[] is = new int[rs.size()];
        for(int i = 0;i<rs.size();++i) {
            is[i] = rs.get(i);
        }
        return is;
    }
}
