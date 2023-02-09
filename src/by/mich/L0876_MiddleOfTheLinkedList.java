package by.mich;

import by.mich.util.ListNode;

/**
 * Given the head of a singly linked list,
 * return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class L0876_MiddleOfTheLinkedList {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/891260619/
    // 100 61
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }
}
