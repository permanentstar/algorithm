package com.star.permanent.algorithm.execise;

/*
* 单位面额 1,3,5 给定一个总额x，求最少使用多少个硬币
* */
public class MinCoins {
    static int[] coin = {3,5,7};
    static int x = 15;

    public static void main(String[] args) {
        System.out.println(minCoins());
    }

    /*
    * 状态保存总额i需要的最少硬币个数
    * stat[i] = 1 + min(stat[i-c1],stat[i-c2],...)
    *
    * */
    private static int minCoins() {
        int[] stat = new int[x+1];  // [0,x]
        for(int i=0;i<coin.length;++i) {
            stat[coin[i]] = 1;
        }
        for(int i=0;i<stat.length;++i) {  // [0,coin[0]) 为无法实现部分
            int min = Integer.MAX_VALUE;
            for(int j=0;j<coin.length;++j) {
                int pre = i-coin[j];
                if(pre >=0 && stat[pre] > 0 && stat[pre] < min) {
                    min = stat[pre];
                }
            }
            if (min != Integer.MAX_VALUE) { // min=MAX 说明该额度无法匹配 留空
                stat[i] = 1 + min;
            }
        }
        return stat[x];
    }
}
