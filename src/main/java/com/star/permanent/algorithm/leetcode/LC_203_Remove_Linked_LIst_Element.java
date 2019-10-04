package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.ListNode;

/*
    移除链表元素
    删除链表中等于给定值 val 的所有节点。
    Remove all elements from a linked list of integers that have value val.
    Example:
    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
    https://leetcode-cn.com/problems/remove-linked-list-elements
* */
public class LC_203_Remove_Linked_LIst_Element {

    public static void main(String[] args ) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                if(curr == head) { // 如果发生在头部 需要更新head和pre
                    head = head.next;
                    pre = head;
                }  // 如果相等  慢指针不动
            } else if(pre != curr){ // 发现不等 慢指针next更新后自己更新
                pre.next = curr;
                pre = curr;
            }
            curr = curr.next; // 快指针每次移动
        }
        if(pre != null) {
            pre.next = null; // 慢指针只看当前值是否符合，全部遍历完应该next为Null，如果不为null说明其后都是目标val
        }
        return head;
    }

    /*
    * 采用守卫节点简化编程
    * */
    public static ListNode removeElementsGuard(ListNode head, int val) {
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode pre = guard;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != val) {
                pre.next = curr;
                pre = curr;
            }
            curr = curr.next; // 快指针每次移动
        }
        pre.next = null; // 慢指针只看当前值是否符合，全部遍历完应该next为Null，如果不为null说明其后都是目标val
        return guard.next;
    }
}
