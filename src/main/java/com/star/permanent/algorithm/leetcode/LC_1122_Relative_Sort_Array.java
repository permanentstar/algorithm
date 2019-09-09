package com.star.permanent.algorithm.leetcode;

//      数组的相对排序
/*
        Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
        Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
        Example 1:
        Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        Output: [2,2,2,1,4,3,3,9,6,7,19]
        Constraints:
        arr1.length, arr2.length <= 1000
        0 <= arr1[i], arr2[i] <= 1000
        Each arr2[i] is distinct.
        Each arr2[i] is in arr1.

        https://leetcode-cn.com/problems/relative-sort-array
*/

import java.util.*;

public class LC_1122_Relative_Sort_Array {

    private static int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
    private static int[] arr2 = {2,1,4,3,9,6};

    public static void main(String[] args) {
        int[] is = relativeSortArrayOptimize(arr1, arr2);
        for(int i = 0;i<is.length;++i) {
            System.out.println(is[i]);
        }
    }
    /*
    * 给了 array size 范围 可以考虑使用计数|桶排
    * */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> a1Map = new HashMap<>(arr2.length);
        for (int a1 : arr1) {
            a1Map.put(a1, a1Map.getOrDefault(a1, 0) + 1);
        }
        int i = 0;
        for (int a2 : arr2) {
            for (int s = 0; s < a1Map.get(a2); ++s) {
                arr1[i++] = a2;
            }
            a1Map.remove(a2);
        }
        Integer[] restKeys = a1Map.keySet().toArray(new Integer[0]);
        Arrays.sort(restKeys);
        for (int rest : restKeys) {
            for (int s = 0; s < a1Map.get(rest); ++s) {
                arr1[i++] = rest;
            }
        }
        return arr1;
    }

    /*
    * 额外给了 value 范围 1000 以内，因此可以替换Map 为基于数组的计数
    * */
    public static int[] relativeSortArrayOptimize(int[] arr1, int[] arr2) {
        int[] base = new int[1001]; // [0, 1000]
        for (int a1: arr1) {
            base[a1] = ++ base[a1];
        }
        int i,j = 0;
        for (int a2: arr2) {
            i = base[a2];
            while (-- i >= 0) {
                arr1[j++] = a2;
            }
            base[a2] = 0;
        }
        int cnt;
        for (int b = 0;b < base.length;++b) {
            cnt = base[b];
            while (-- cnt >= 0) {
                arr1[j++] = b;
            }
        }
        return arr1;
    }
}
