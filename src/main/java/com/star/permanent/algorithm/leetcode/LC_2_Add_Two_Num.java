package com.star.permanent.algorithm.leetcode;

import java.util.List;

/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
    and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
    https://leetcode-cn.com/problems/add-two-numbers
* */
public class LC_2_Add_Two_Num {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */


    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode p1 = new ListNode(8);
        l1.next = p1;
//        p1.next = new ListNode(3);
        ListNode l2 = new ListNode(0);
//        ListNode p2 = new ListNode(6);
//        l2.next = p2;
//        p2.next = new ListNode(4);
        ListNode c = addTwoNumbers(l1,l2);
        ListNode p = c;
        while (p!= null){
            System.out.println(p.val);
            p = p.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i1 = 0,i2 = 0,imax;
        ListNode ll1 = l1;
        while (ll1 != null) {
            ll1 = ll1.next;
            ++i1;
        }
        ListNode ll2 = l2;
        while (ll2 != null){
            ll2 = ll2.next;
            ++i2;
        }
        imax = Math.max(i1,i2);
        ListNode longer = l1;
        ListNode shorter = l2;
        if (imax != i1) {
            longer = l2;
            shorter = l1;
        }
        int highest = 0;
        ListNode head = longer;
        while(true) {
            if (shorter != null) {
                longer.val = longer.val + shorter.val;
                shorter = shorter.next;
            }
            if (longer.val >= 10) {
                longer.val = longer.val - 10;
                if (longer.next != null) {
                    longer.next.val = longer.next.val + 1;  // 导致最后一位也可能需要额外处理进位
                } else {
                    ++highest;
                }
            }
            if (longer.next == null){
                break;
            }
            longer = longer.next;
        }
        if (highest > 0) {
            longer.next = new ListNode(highest);
        }
        return head;
    }

    public static ListNode addTwoNumbersOptimize(ListNode l1, ListNode l2) {
        boolean high = false;
        boolean swapped = false;
        ListNode head = l1;
        while (true) {
            if(l2 != null) {
                l1.val = l1.val + l2.val;
            }
            if (l1.val >= 10) {
                l1.val = l1.val - 10;
                if (!swapped) {
                    swapped = trySwapChild(l1, l2);
                }
                if (l1.next != null) {
                    l1.next.val = l1.next.val + 1;
                } else {
                    high = true;
                }
            }
            if(!swapped){
                swapped = trySwapChild(l1,l2);
            }
            if(l1.next == null) {
                break;
            }
            l1 = l1.next;
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (high) {
            l1.next = new ListNode(1);
        }
        return head;
    }

    private static boolean trySwapChild(ListNode l1, ListNode l2) {
        if (l1.next == null && l2 != null && l2.next != null){  // l1 短，之前sum到l1上 需要l1 l2 在此点交换后续链表
            ListNode tmp = l2.next;
            l2.next = null;
            l1.next = tmp;
            return true;
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
