package com.star.permanent.algorithm.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode reverse(ListNode root) {
        if(root == null) return null;
        ListNode head = root;
        ListNode tmp;
        while (root.next!= null) {
            tmp = root.next.next;  //root下下个节点备份
            root.next.next = head; //root下个节点旋转到head前
            head = root.next; // head更新
            root.next = tmp; //更新root下一个
        }
        return head;
    }
}
