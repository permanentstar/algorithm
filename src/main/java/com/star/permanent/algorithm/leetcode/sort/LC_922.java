package com.star.permanent.algorithm.leetcode.sort;
//      按奇偶排序数组 II
/*
        给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
        对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
        你可以返回任何满足上述条件的数组作为答案。
        示例：
        输入：[4,2,5,7]
        输出：[4,5,2,7]
        解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
*/

public class LC_922 {
    private static final int[] A = {1,3,4,5,8,2};
    public static void main(String[] args) {
        int[] is = sortArrayByParityII(A);
        for(int i = 0;i<is.length;++i) {
            System.out.println(is[i]);
        }
    }

    private static int temp;
    public static int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        for(int i = 0,j=1;i<len && j< len;) {
            if (even(A[i])) {
                while (even(A[j])) {
                    j += 2;
                    if (j >= len) {
                        break;
                    }
                }
                if (j < len) {
                    swap(A, i, j);
                    i += 2;
                    j += 2;
                }
            } else {
                i += 2;
            }
        }
        return A;
    }
    private static boolean even(int num) {
        return (num >> 1) != ((num + 1) >> 1);
    }
    private static void swap(int[] A,int i, int j) {
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
