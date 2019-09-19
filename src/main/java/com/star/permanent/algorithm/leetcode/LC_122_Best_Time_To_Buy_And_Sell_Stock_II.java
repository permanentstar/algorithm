package com.star.permanent.algorithm.leetcode;
    /*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
    Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
    Example 1:
    Input: [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Example 2:
    Input: [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
                 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
                 engaging multiple transactions at the same time. You must sell before buying again.
    Example 3:
    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
* */
public class LC_122_Best_Time_To_Buy_And_Sell_Stock_II {
    static int[] p = {7,1,5,3,6,4};
    static int[] p1 = {1,2,3,4,5};
    static int[] p2 = {7,6,4,3,1};
    public static void main(String[] args) {
        System.out.println(maxProfit(p1));
    }
    /*
    * 直观方法，分段求最大和，即找出每个最大单调增区间的max-min并求和
    * */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int sum = 0;
        int low = prices[1]>prices[0] ? prices[0]:Integer.MIN_VALUE;
        for(int i=1;i<prices.length;++i) {
            if (i == prices.length - 1) {
                if (low != Integer.MIN_VALUE) {  // trade still open
                    sum += prices[i] - low;
                }
            } else if (prices[i] <= prices[i-1] && prices[i]<prices[i+1]) {  // 极小值
                low = prices[i];
            } else if (prices[i]>prices[i-1] && prices[i]>=prices[i+1]) { // 极大值
                sum += prices[i] - low;
                low = Integer.MIN_VALUE;
            }
        }
        return sum;
    }

    public static int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i=1;i<prices.length;++i) {
            if (prices[i] > prices[i-1]) {
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}
