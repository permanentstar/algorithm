package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.ListNode;

/*
    环形链表
    给定一个链表，判断链表中是否有环。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    Given a linked list, determine if it has a cycle in it.
    To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
    Example 1:
    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where tail connects to the second node.
    Example 2:
    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where tail connects to the first node.
    Example 3:
    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.
    Follow up:
    Can you solve it using O(1) (i.e. constant) memory?
    https://leetcode-cn.com/problems/linked-list-cycle
* */
public class LC_141_Linked_LIst_Cycle {

    public static void main(String[] args) {

    }

    /*
    * 快慢指针 两种结果
    * 1. 快指针到头 -> 无环
    * 2. 快慢指针相交 -> 有环
    * */
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            fast = fast.next;
            if (fast == null){
                return false;
            }
            fast = fast.next;
            if (fast == null){
                return false;
            }
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
    }
}
