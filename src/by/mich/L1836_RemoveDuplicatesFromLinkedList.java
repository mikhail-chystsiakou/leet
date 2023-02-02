package by.mich;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the head of a linked list, find all the values that appear
 * more than once in the list and delete the nodes that have any of those values.
 *
 * Return the linked list after the deletions.
 */
public class L1836_RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(
            3,
            new ListNode(2,
            new ListNode(2,
            new ListNode(1,
            new ListNode(3,
            new ListNode(2,
            new ListNode(4)
        ))))));
//        ListNode node = new ListNode(
//            1,
//            new ListNode(2,
//            new ListNode(3,
//            new ListNode(2)
//        )));
        deleteDuplicatesUnsorted(node);
    }

    public static ListNode deleteDuplicatesNoBuffer(ListNode head) {
        ListNode newHead = head;
        ListNode headItPrev = null;
        ListNode headIt = head;
        while (headIt != null) {
            boolean remove = false;
            ListNode tmpHeadPrev = headIt;
            ListNode tmpHead = headIt.next;
            while (tmpHead != null) {
                if (headIt.val == tmpHead.val) {
                    remove = true;
                    tmpHeadPrev.next = tmpHead.next;
                } else {
                    tmpHeadPrev = tmpHeadPrev.next;
                }
                tmpHead = tmpHead.next;
            }
            if (remove) {
                if (headItPrev == null) {
                    newHead = newHead.next;
                } else {
                    headItPrev.next = headIt.next;
                }
                headIt = headIt.next;
            } else {
                headItPrev = headIt;
                headIt = headIt.next;
            }
        }
        return newHead;
    }

    // https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/submissions/890023040/
    // 85 94
    public static ListNode deleteDuplicatesUnsorted(ListNode head) {
        Set<Integer> exists = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        ListNode headPtr = head;
        while (headPtr != null) {
            if (exists.contains(headPtr.val)) {
                duplicates.add(headPtr.val);
            } else {
                exists.add(headPtr.val);
            }
            headPtr = headPtr.next;
        }

        ListNode newHead = head;
        while (newHead != null && duplicates.contains(newHead.val)) newHead = newHead.next;

        headPtr = newHead;
        while (headPtr!= null && headPtr.next != null) {
            if (duplicates.contains(headPtr.next.val)) {
                headPtr.next = headPtr.next.next;
            } else {
                headPtr = headPtr.next;
            }
        }

        return newHead;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
