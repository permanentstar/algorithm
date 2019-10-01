package com.star.permanent.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    找到所有数组中消失的数字
    给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
    找到所有在 [1, n] 范围之间没有出现在数组中的数字。
    您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    Find all the elements of [1, n] inclusive that do not appear in this array.
    Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
    Example:
    Input:
    [4,3,2,7,8,2,3,1]
    Output:
    [5,6]
    https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
* */
public class LC_448_All_Numbers_Disappeared_In_Array {
    static int[] nums = {4,3,2,7,8,2,3,1};
    public static void main(String[] args) {
        List<Integer> rs = findDisappearedNumbers(nums);
        rs.forEach(i->System.out.print(i+ " "));
    }

    /*
    * 要点： 数组长度n 范围 [0,n-1] 数据范围[1,n]
    * P[x]-1 属于 [0,n-1] 已遍历的将value设为0 最后不为0的索引+1即为缺失数字集合
    * 不连续访问 根据value跳着访问 一次遍历时间复杂度O(n)
    * */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i;
        int next;
        List<Integer> rs = new ArrayList<>();
        for(int s=0;s<nums.length;++s) {
            if (nums[s] > 0) {
                i = nums[s]-1;
                while (nums[i]!=0) { // i  nums[i]
                    next = nums[i]; // 当前值所在索引指向的下一个值
                    nums[i] = 0;
                    i = next-1;
                }
            }
        }
        for(int s=0;s<nums.length;++s) {
            if (nums[s] != 0) {
                rs.add(s+1);
            }
        }
        return rs;
    }
}
