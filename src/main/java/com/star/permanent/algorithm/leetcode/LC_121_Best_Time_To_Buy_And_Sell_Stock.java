package com.star.permanent.algorithm.leetcode;

/*
    Say you have an array for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    Note that you cannot sell a stock before you buy one.
    Example 1:
    Input: [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                 Not 7-1 = 6, as selling price needs to be larger than buying price.
    Example 2:
    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
* */

public class LC_121_Best_Time_To_Buy_And_Sell_Stock {

    public static void main(String[] args) {

    }

    /*
    * 对角矩阵 (y,x)  val = P[y]-P[x] 求最大值
    * O(n^2)
    * */
    public static int maxProfit1(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int max = 0;
        for(int y=1;y<len;++y) {
            for (int x=0;x<y;++x) {
                int delta = prices[y] - prices[x];
                if (delta > max) {
                    max = delta;
                }
            }
        }
        return max;
    }

}
