package com.star.permanent.algorithm.leetcode;

import com.star.permanent.algorithm.util.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    环形链表 II
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    说明：不允许修改给定的链表。
    示例 1：
    输入：head = [3,2,0,-4], pos = 1
    输出：tail connects to node index 1
    解释：链表中有一个环，其尾部连接到第二个节点。
    示例 2：
    输入：head = [1,2], pos = 0
    输出：tail connects to node index 0
    解释：链表中有一个环，其尾部连接到第一个节点。
    示例 3：
    输入：head = [1], pos = -1
    输出：no cycle
    解释：链表中没有环。
    进阶：
    你是否可以不用额外空间解决此题？
    https://leetcode-cn.com/problems/linked-list-cycle-ii
* */
public class LC_142_Linked_List_Circle_II {

    /*
    * 相遇后  Lf=s1+nC+s2 Lf=2Ls Ls=s1+s2  s1为起始点到入环长度 s2为入环到交点长度
    * 2(s1+s2)=s1+nC+s2 => nC=s1+s2
    * 新建一个head 指针从0开始  另一个为fast指针  两个指针step=1 前进 s1步长后再次相遇
    * 0+s1=s1 s1+nC+s2+s1=s1+2nC
    * */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
