package com.star.permanent.algorithm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeqUtil {
    public static void main(String[] args) {
        genRandNums(0, 10, 15);
    }

//    [low, high]
    private static void genRandNums(int low, int high, int cnt) {
        Random random = new Random();
        int minus = high - low + 1;
        List<Integer> arr = new ArrayList<Integer>(cnt);
        for (int i = 0;i<cnt;++i) {
            arr.add(random.nextInt(minus) + low);
        }
        System.out.println(arr);
    }

    private static void revertArray(int[] a, int s, int e) {
        int tmp;
        while (s<e) {
            tmp = a[s];
            a[s] = a[e];
            a[e] = tmp;
            ++s;
            --e;
        }
    }
}
