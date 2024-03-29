package com.star.permanent.algorithm.leetcode;

import java.util.*;

//      两个数组的交集
        /*
        Given two arrays, write a function to compute their intersection.
        Example 1:
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2]
        Example 2:
        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [9,4]
        Note:
        Each element in the result must be unique.
        The result can be in any order.

        https://leetcode-cn.com/problems/intersection-of-two-arrays
        */
public class LC_349_Intersection_of_Two_Arrays {
    private static int[] nums1 = {1,4,2,4,5,7,9};
    private static int[] nums2 = {9,3,4,4,2,7};
    public static void main(String[] args)  {
        int[] is = intersection2(nums1, nums2);
        for(int i = 0;i<is.length;++i) {
            System.out.println(is[i]);
        }
    }

    public static int[] intersection1(int[] nums1, int[] nums2) {
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<nums1.length;++i) {
            map.putIfAbsent(nums1[i], false);
        }
        Integer key = null;
        for(int i = 0;i < nums2.length;++i) {
            key = nums2[i];
            if (map.containsKey(key))
            map.put(key, true);
        }
        List<Integer> rs = new ArrayList<>();
        for (Map.Entry<Integer,Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                rs.add(entry.getKey());
            }
        }
        int[] is = new int[rs.size()];
        for(int i = 0;i< rs.size();++i) {
            is[i] = rs.get(i);
        }
        return is;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
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
                if (i1 ==0 || n1 != nums1[i1-1]){
                    rs.add(n1);
                }
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
