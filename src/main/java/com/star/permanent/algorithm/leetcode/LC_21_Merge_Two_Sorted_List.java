package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.ListNode;


/*
    合并两个有序链表
    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
    Example:
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
    https://leetcode-cn.com/problems/merge-two-sorted-lists
* */
public class LC_21_Merge_Two_Sorted_List {
    static ListNode l1 = new ListNode(1);
    static ListNode l2 = new ListNode(1);
    static int[] a1 = {2,4};
    static int[] a2 = {3,4,5,6};
    public static void main(String[] args) {
        ListNode p1 = l1;
        for (int i = 0;i<a1.length;++i) {
            p1.next = new ListNode(a1[i]);
            p1 = p1.next;
        }
        ListNode p2 = l2;
        for (int i = 0;i<a2.length;++i) {
            p2.next = new ListNode(a2[i]);
            p2 = p2.next;
        }
        ListNode merged = mergeTwoListsByRecur(l1,l2);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }

    /*
    * 基于连续小于的区间批量merge 相比指定一个头节点然后逐个元素比较推进的方法减少了指针修改的次数
    * */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {  // return l1
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        ListNode head = l1;
        ListNode pre1 = l1;
        ListNode pre2 = l2;
        ListNode start2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val){
                pre1 = l1;
                l1 = l1.next;
            } else {
                start2 = l2;
                while (l2 != null) {
                    if (l1.val <= l2.val) {
                        // start2~pre2 merge into l1
                        break;
                    }
                    pre2 = l2;
                    l2 = l2.next;
                }
                pre1.next = start2;
                pre2.next = l1;
            }
        }
        if (l2 != null) { // append left int l2 to l1
            pre1.next = l2;
        }
        return head;

    }

    /*
    * 简易指针移动版(逐个元素添加)
    * */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(-1); // guard pointer
        ListNode preHead = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                preHead.next = l1;
                l1 = l1.next;
            } else {
                preHead.next = l2;
                l2 = l2.next;
            }
            preHead = preHead.next;
        }
        if (l1 != null) {   // 因为采用守卫节点 l1 l2平级，任意剩余元素都需要显式加入preHead
            preHead.next = l1;
        } else {
            preHead.next = l2;
        }
        return head.next;
    }

    public static ListNode mergeTwoListsByRecur(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsByRecur(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecur(l1, l2.next);
            return l2;
        }
    }


}
