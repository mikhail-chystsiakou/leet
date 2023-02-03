package by.mich;

import by.mich.util.ListNode;

/**
 * You are given two non-empty linked lists representing
 * two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers
 * and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 */
public class L0002_AddTwoNumbers {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/add-two-numbers/submissions/890592308/
    // 95 53
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode last = result;
        int overflow = 0;
        while (l1 != null || l2 != null) {
            int newValue = overflow;
            overflow = 0;
            if (l1 != null) {
                newValue += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                newValue += l2.val;
                l2 = l2.next;
            }
            if (newValue >= 10) {
                newValue -= 10;
                overflow = 1;
            }
            last.next = new ListNode(newValue);
            last = last.next;
        }
        if (overflow > 0) {
            last.next = new ListNode(overflow);
        }

        return result.next;
    }
}
