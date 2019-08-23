package com.star.permanent.algorithm.basic;

public class BinSearch {

    private static final int[] seq = {1, 1, 2, 3, 7, 12, 14, 20, 20, 20, 20, 27, 28, 36, 44, 46, 52};
    private static final int[] cycleSeq = {14, 20, 20, 20, 20, 27, 28, 36, 44, 46, 52, 1, 1, 2, 3, 7, 12};

    public static void main(String[] args) {
//        int i = binSearchRecur(seq, 0, seq.length - 1, 20, true);
        int i = cycledBinSearchRecur(cycleSeq, 20, true);
        System.out.println(i);
    }

    private static int binSearchRecur(int[] a, int low, int high, int t, boolean findLeftMost) {
        if(low == high) {
            if (a[low] == t) {
                return low;
            } else return -1;
        }
        int mid = low + ((high - low) >> 1);
        int v = a[mid];
        if (v == t) {
            return findLeftMost ? binSearchRecur(a, low, mid,t, findLeftMost) : mid;
        } else if (v < t) {
            return binSearchRecur(a, mid + 1, high, t, findLeftMost);
        } else {
            return binSearchRecur(a, low, mid,t, findLeftMost);
        }
    }

    private static int cycledBinSearchRecur(int[] a, int t, boolean findLeftMost) {
        return -1;
    }
}
