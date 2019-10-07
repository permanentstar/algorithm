package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.ListNode;

/*
    删除链表中的节点
    请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
    Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
    Given linked list -- head = [4,5,1,9], which looks like following:
    Example 1:
    Input: head = [4,5,1,9], node = 5
    Output: [4,1,9]
    Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
    Example 2:
    Input: head = [4,5,1,9], node = 1
    Output: [4,5,9]
    Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
    Note:
    The linked list will have at least two elements.
    All of the nodes' values will be unique.
    The given node will not be the tail and it will always be a valid node of the linked list.
    Do not return anything from your function.
    https://leetcode-cn.com/problems/delete-node-in-a-linked-list
* */
public class LC_237_Delete_Node_In_Linked_List {

    public static void main(String[] args) {

    }

    public static void deleteNode(ListNode node) {
        ListNode tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail = ListNode.reverse(tail);
        ListNode pre = tail;
        ListNode curr = tail;
        while (curr != node) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = curr.next;
        ListNode.reverse(tail);
    }
}
