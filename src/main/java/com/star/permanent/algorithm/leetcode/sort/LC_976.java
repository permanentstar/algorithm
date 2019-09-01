package com.star.permanent.algorithm.leetcode.sort;

import java.util.Arrays;

//      三角形的最大周长
/*
        给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
        如果不能形成任何面积不为零的三角形，返回 0。
        示例 1：
        输入：[2,1,2]
        输出：5
        示例 2：
        输入：[1,2,1]
        输出：0
        示例 3：
        输入：[3,2,3,4]
        输出：10
        示例 4：
        输入：[3,6,2,3]
        输出：8
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
*/
public class LC_976 {
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
