package com.star.permanent.algorithm.leetcode;

/*
        给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
        Given an array nums and a value val, remove all instances of that value in-place and return the new length.
        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
        The order of elements can be changed. It doesn't matter what you leave beyond the new length.
        Example 1:
        Given nums = [3,2,2,3], val = 3,
        Your function should return length = 2, with the first two elements of nums being 2.
        It doesn't matter what you leave beyond the returned length.
        Example 2:
        Given nums = [0,1,2,2,3,0,4,2], val = 2,
        Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
        Note that the order of those five elements can be arbitrary.
        It doesn't matter what values are set beyond the returned length.
        Clarification:
        Confused why the returned value is an integer but your answer is an array?
        Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
        Internally you can think of this:
        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeElement(nums, val);
        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }
        https://leetcode-cn.com/problems/remove-element
* */
public class LC_27_Remove_Element {


    public static void main(String[] args) {

    }
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int s = 0;
        int e = len - 1;
        while (s < e) {
            while (s < e && nums[s] != val) ++s;
            while (e > s && nums[e] == val) --e;
            swap(nums, s, e);
        }
        return nums[s] == val ? s: s + 1; // nums[s]=val 说明最后一次未真正交换或原地交换val
    }

    private static void swap(int[] nums, int s, int e) {
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }
}
