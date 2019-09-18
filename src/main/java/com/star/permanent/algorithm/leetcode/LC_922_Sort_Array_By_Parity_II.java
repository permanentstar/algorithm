package com.star.permanent.algorithm.leetcode;
//      按奇偶排序数组 II
/*
        给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
        对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
        你可以返回任何满足上述条件的数组作为答案。
        Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
        Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
        You may return any answer array that satisfies this condition.
        Example 1:
        Input: [4,2,5,7]
        Output: [4,5,2,7]
        Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
        Note:
        2 <= A.length <= 20000
        A.length % 2 == 0
        0 <= A[i] <= 1000

        https://leetcode-cn.com/problems/sort-array-by-parity-ii
*/

public class LC_922_Sort_Array_By_Parity_II {
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
