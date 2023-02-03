package by.mich;

import by.mich.util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a
 * linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except
 * the number 0 itself.
 */
public class L0445_AddTwoNumbers2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1l = 0;
        ListNode i = l1;
        while (i != null) {
            i = i.next;
            l1l++;
        }
        i = l2;
        int l2l = 0;
        while (i != null) {
            i = i.next;
            l2l++;
        }
        HeadCarry hc;
        if (l1l >= l2l) {
            hc = addTwoNumbersRecursive(l1, l2, l1l-l2l);
        } else {
            hc = addTwoNumbersRecursive(l2, l1, l2l-l1l);
        }
        if (hc.carry > 0) {
            ListNode newHead = new ListNode(hc.carry, hc.head);
            hc.head = newHead;
        }
        return hc.head;
    }

    // https://leetcode.com/problems/add-two-numbers-ii/submissions/890605022/
    // 100 63
    public static HeadCarry addTwoNumbersRecursive(ListNode l1, ListNode l2, int skip) {
        HeadCarry hc = new HeadCarry();
        if (skip > 0) {
            hc = addTwoNumbersRecursive(l1.next, l2, skip-1);
        } else if (l1.next != null) {
            hc = addTwoNumbersRecursive(l1.next, l2.next, skip-1);
        }
        int l2val = skip > 0 ? 0 : l2.val;

        int newValue = l1.val + l2val + hc.carry;

        ListNode newHead = new ListNode(newValue % 10);
        newHead.next = hc.head;
        hc.carry = newValue / 10;
        hc.head = newHead;

        return hc;
    }

    static class HeadCarry {
        ListNode head;
        int carry;

        HeadCarry() {
            head = null;
            carry = 0;
        }

        HeadCarry(ListNode head, int carry) {
            this.head = head;
            this.carry = carry;
        }
    }
}
