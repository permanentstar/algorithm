package com.star.permanent.algorithm.leetcode;

import java.util.Arrays;

//  删除排序数组中的重复项
/*
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    Example 1:
    Given nums = [1,1,2],
    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
    It doesn't matter what you leave beyond the returned length.
    Example 2:
    Given nums = [0,0,1,1,1,2,2,3,3,4],
    Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
    It doesn't matter what values are set beyond the returned length.
    Clarification:
    Confused why the returned value is an integer but your answer is an array?
    Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
    Internally you can think of this:
    // nums is passed in by reference. (i.e., without making a copy)
    int len = removeDuplicates(nums);
    // any modification to nums in your function would be known by the caller.
    // using the length returned by your function, it prints the first len elements.
    for (int i = 0; i < len; i++) {
        print(nums[i]);
    }
     https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
* */
public class LC_26_Remove_Duplicates_From_Sorted_Array {
    public static int[] a = {1,1,2,2,6,7,7,7,8,8,9,10};
    static int[] b = {1,1,2};
    public static void main(String[] args) {
        int[] array = a;
        int len = removeDuplicatesOptimize(array);
        System.out.println(len);
        for (int i=0;i<len;++i) {
            System.out.println(array[i]);
        }
    }

    /*
    * 破坏元数据信息
    * */
    public static int removeDuplicatesOptimize(int[] nums) {
        if(nums.length == 0) return 0;
        int pos = 0;
        int next = 0;
        while (++next < nums.length) {
            if (nums[next] != nums[pos]) {
                nums[++pos] = nums[next];
            }
        }
        return pos + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        int l = 0, r = 0;
        while(r < nums.length) {
            while(r < nums.length && nums[r] == nums[l])
                r++;
            if(r == nums.length) return l+1;
            swap(nums, ++l, r++);
        }
        return l+1;
    }

    /*
    * 使用交换 保留原数据信息
    * */
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int pos = 0;
        int next = 0;
        while (++next < nums.length) {
            if (nums[next] > nums[pos]) {
                next = ++pos;
            } else{
                int start = next + 1;
                boolean swapped = false;
                while (start < nums.length) {
                    if (nums[start] > nums[pos]){  // 交换一次之后 后面的数字就不是升序了 因此被比较的必须是pos下标的value
                        swap(nums, next, start);    // 交换的是pos+1(即next)
                        ++ pos;
                        swapped = true;
                        break;
                    }
                    ++ start;
                }
                if (!swapped)    {
                    return pos + 1;
                }
            }
        }
        return pos + 1;
    }

    private static void swap(int[] nums, int s, int t) {
        int tmp = nums[s];
        nums[s] = nums[t];
        nums[t] = tmp;
    }

}
