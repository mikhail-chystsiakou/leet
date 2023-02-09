package by.mich;

import by.mich.util.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made
 * by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class L0021_MergeTwoSortedLists {
    public static void main(String[] args) {
    }


    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    // 100 64
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            } else if (list2 == null) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else if (list1.val >= list2.val) {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        return head.next;
    }
}
