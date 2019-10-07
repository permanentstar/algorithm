package com.star.permanent.algorithm.leetcode;

/*
    字符串相乘
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
    Example 1:
    Input: num1 = "2", num2 = "3"
    Output: "6"
    Example 2:
    Input: num1 = "123", num2 = "456"
    Output: "56088"
    Note:
    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
    https://leetcode-cn.com/problems/multiply-strings
* */
public class LC_43_Multiply_Strings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1,num2));
    }
    /*
    * n位 * n位 结果小于等于 n*2 位 申请n*2 大小数据从后往前逐位模拟手工计算进位
    * */

    public static String multiply(String num1, String num2) {
        int[] rs = new int[num1.length()+num2.length()];
        int tmp;
        int latest;
        for(int i=num1.length()-1;i>=0;--i) {
            tmp = num1.charAt(i) - '0';
            latest = num1.length() + num2.length() - 1 - (num1.length()-1-i); // 每次往前推进一位
            for(int j=num2.length()-1;j>=0;--j) {
                rs[latest] += (num2.charAt(j) - '0') * tmp;  // 进位最后处理
                -- latest;
            }
        }
        for(int i = rs.length-1;i>=1;--i) {  //处理进位 最高位一定不会溢出
            rs[i-1] += rs[i] / 10;
            rs[i] = rs[i] % 10;
        }
        boolean head = true;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<rs.length;++i) {
            if (!head) {
                builder.append(rs[i]);
            } else if (rs[i] != 0) {
                head = false;
                builder.append(rs[i]);
            }
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
