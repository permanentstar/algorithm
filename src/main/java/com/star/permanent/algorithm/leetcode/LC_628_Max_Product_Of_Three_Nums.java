package com.star.permanent.algorithm.leetcode;

import java.util.Arrays;

/*
    三个数的最大乘积
    给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
    Given an integer array, find three numbers whose product is maximum and output the maximum product.
    Example 1:
    Input: [1,2,3]
    Output: 6
    Example 2:
    Input: [1,2,3,4]
    Output: 24
    Note:
    The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
    Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
    https://leetcode-cn.com/problems/maximum-product-of-three-numbers
* */
public class LC_628_Max_Product_Of_Three_Nums {
    static int[] nums = {-1,-2,-3};
    static int[] nums2 = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};

    public static void main(String[] args) {
        System.out.println(maximumProduct(nums));
    }

    /*
    * 手动做top3和bottom2的排序
    * */
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        Integer temp;
        for (int i = 0;i<nums.length;++i) {
            temp = null;
            if (nums[i] >= max1) {
                temp = max3;
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] >= max2) {
                temp = max3;
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] >= max3) {
                temp = max3;
                max3 = nums[i];
            } else if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] <= min2) {
                min2 = nums[i];
            }
            if(temp != null && temp != Integer.MIN_VALUE) {  // max3 pop up to determine min1 min2 对于未初始化的max3跳过
                if (temp <= min1) {
                    min2 = min1;
                    min1 = temp;
                } else if (temp <= min2) {
                    min2 = temp;
                }
            }
        }
        int m1 = max1*max2*max3;  // 至少3个元素
        int m2 = 0;
        if (min1 == Integer.MAX_VALUE && min2 == Integer.MAX_VALUE) { //只有三个元素
            return m1;
        }
        if (min1 != Integer.MAX_VALUE && min2 != Integer.MAX_VALUE) {
            m2 = min1*min2*max1;
        } else if(min1 != Integer.MAX_VALUE) { // 4个元素 则 min2为空
            m2 = min1*max3*max1;  // max3当做min2
        }
        return Math.max(m1,m2);
    }

    public static int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length-1] == 0) return 0;
        int max = 1;
        for(int i = nums.length-1;i> nums.length-4;--i) {
            max *= nums[i];
        }
        if (nums[nums.length-1] < 0) { // 注意 即使3个+相乘 此处也不一定是最大
            return max;
        }
        int max2 = 1;  // 可能存在的 多个负值
        for(int i = 0;i<2;++i) {
            max2 *= nums[i];
        }
        max2 *= nums[nums.length-1];
        return Math.max(max,max2);
    }
}
