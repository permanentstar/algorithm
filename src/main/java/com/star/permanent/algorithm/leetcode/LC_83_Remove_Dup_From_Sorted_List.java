package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.ListNode;

/*
    删除排序链表中的重复元素
    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
    Given a sorted linked list, delete all duplicates such that each element appear only once.
    Example 1:
    Input: 1->1->2
    Output: 1->2
    Example 2:
    Input: 1->1->2->3->3
    Output: 1->2->3
    https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
* */
public class LC_83_Remove_Dup_From_Sorted_List {

    public static void main(String[] args) {

    }
    /*
    * 快慢指针法
    * */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        if (slow != null) {  // 也可以每个while里冗余执行一次slow.next=null 因为slow=slow.next后slow并不关心后一个next是多少
            slow.next = null;
        }
        return head;
    }
}
