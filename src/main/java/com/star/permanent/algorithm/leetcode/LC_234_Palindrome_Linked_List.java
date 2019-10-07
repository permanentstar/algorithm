package com.star.permanent.algorithm.leetcode;


import com.star.permanent.algorithm.util.ListNode;

/*
    回文链表
    请判断一个链表是否为回文链表。
    Given a singly linked list, determine if it is a palindrome.
    Example 1:
    Input: 1->2
    Output: false
    Example 2:
    Input: 1->2->2->1
    Output: true
    Follow up:
    Could you do it in O(n) time and O(1) space?
    https://leetcode-cn.com/problems/palindrome-linked-list
* */
public class LC_234_Palindrome_Linked_List {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            ++cnt;
            p = p.next;
        }
        int half = (cnt >> 1); // mid or left mid
        p = head;
        while (half-- > 0) {
            p = p.next;
        }
        p = ListNode.reverse(p);
        while (p !=null && head != null) {
            if (head.val != p.val) return false;
            p = p.next;
            head = head.next;
        }
        return true;
    }
}
