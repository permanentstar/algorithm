package com.star.permanent.algorithm.leetcode;

import java.util.Arrays;

//      三角形的最大周长
/*
        Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
        If it is impossible to form any triangle of non-zero area, return 0.
        Example 1:
        Input: [2,1,2]
        Output: 5
        Example 2:
        Input: [1,2,1]
        Output: 0
        Example 3:
        Input: [3,2,3,4]
        Output: 10
        Example 4:
        Input: [3,6,2,3]
        Output: 8
        Note:
        3 <= A.length <= 10000
        1 <= A[i] <= 10^6

        https://leetcode-cn.com/problems/largest-perimeter-triangle
*/
public class LC_976_Largest_Perimeter_Triangle {
    /*
    * 先排序， a + b > c  c为最大值，次大和第三大若不满足 a,b 则c变为次大值，依次类推
    */
    private static final int[] A = {3,6,2,3};
    public static void main(String[] args) {
        System.out.println(largestPerimeter(A));
    }


    public static int largestPerimeter(int[] A) {
        if (A.length < 3) return 0;
        Arrays.sort(A);
        int len = A.length;
        int i = len - 1; // c
        while (i >= 2) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
            --i;
        }
        return 0;
    }
}
