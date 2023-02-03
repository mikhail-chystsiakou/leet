package by.mich;

import by.mich.util.ListNode;

/**
 * Given the head of a singly linked list, reverse the list,
 * and return the reversed list.
 */
public class L0206_ReverseLinkedList {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/reverse-linked-list/submissions/890628293/
    // 100 55
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode prevHead = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = prevHead;
            prevHead = head;
            head = next;
        }
        head.next = prevHead;

        return head;
    }
}
