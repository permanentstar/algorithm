package com.star.permanent.algorithm.execise;
/*
* 起始单细胞，生命周期3小时，每个一小时分裂一次，求n小时后细胞数
* */
public class CellTTLSplit {
    public static void main(String[] args) {
        int h = 3;
        System.out.println(String.format("split first result %d", splitFirst(h)));
        System.out.println(String.format("dir first result %d", dieFirst(h)));
    }

    /*
    * 先分裂再死亡
    *
    * f(n) = f(n-1)*2 - f(n-3)
    * f(2) = 4
    * f(1) = 2
    * f(0) = 1
    * */
    private static int splitFirst(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 4;
        return (splitFirst(n-1) << 1) - splitFirst(n-3);
    }

    /*
    * 直接死亡不分裂
    * f(n) = (f(n-1)-f(n-3))*2
    * f(2) = 4
    * f(1) = 2
    * f(0) = 1
    * */
    private static int dieFirst(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 4;
        return (splitFirst(n-1) - splitFirst(n-3)) << 1;
    }
}
