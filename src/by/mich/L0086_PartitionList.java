package by.mich;

import by.mich.util.ListNode;

/**
 * Given the head of a linked list and a value x, partition it such
 * that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes
 * in each of the two partitions.
 */
public class L0086_PartitionList {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/partition-list/submissions/890586259/
    // 100 91
    public static ListNode beautyPartition(ListNode head, int x) {
        ListNode before = null;
        ListNode beforeHead = null;
        ListNode after = null;
        ListNode afterHead = null;

        ListNode i = head;;
        while (i != null) {
            if (i.val < x) {
                if (beforeHead == null) {
                    beforeHead = i;
                    before = i;
                } else {
                    before.next = i;
                    before = i;
                }
            } else {
                if (afterHead == null) {
                    afterHead = i;
                    after = i;
                } else {
                    after.next = i;
                    after = i;
                }
            }
            i = i.next;
        }
        after.next = null;

        if (before != null) {
            before.next = afterHead;
        } else {
            return afterHead;
        }

        return beforeHead;
    }

    // https://leetcode.com/problems/partition-list/submissions/890576654/
    // 100 62
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode j = head;
        ListNode jPrev = null;
        while (j != null && j.val >= x) {
            jPrev = j;
            j = j.next;
        }
        if (j != null && jPrev != null) {
            ListNode jNext = j.next;
            j.next = head;
            jPrev.next = jNext;
            head = j;
        }

        ListNode left = head;
        ListNode i = head.next;
        ListNode iPrev = head;

        while (i != null) {
            boolean moveLeft = i.val < x;
            if (i.val < x && iPrev.val >= x) {
                ListNode leftNext = left.next;
                ListNode iNext = i.next;
                left.next = i;
                i.next = leftNext;
                iPrev.next = iNext;

                i = iNext;
            } else {
                iPrev = i;
                i = i.next;
            }
            if (moveLeft) {
                left = left.next;
            }
        }
        return head;
    }
}
