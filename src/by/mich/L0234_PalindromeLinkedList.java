package by.mich;

import by.mich.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome or false otherwise.
 */
public class L0234_PalindromeLinkedList {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/palindrome-linked-list/submissions/890618321/
    // 48 79
    public static boolean isPalindromeStack(ListNode head) {
        if (head == null) return false;

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode i = head;
        while (i != null) {
            stack.push(i);
            i = i.next;
        }
        i = head;
        while (i != null) {
            ListNode n = stack.pop();
            if (n.val != i.val) return false;
            i = i.next;
        }

        return true;
    }

    // https://leetcode.com/problems/palindrome-linked-list/submissions/890615578/
    // 34 41
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        return isPalindromeRecursive(new Box(head), head.next);
    }

    public boolean isPalindromeRecursive(Box b, ListNode tail) {
        if (b.n == tail) return true;

        boolean result = true;
        if (tail.next != null) {
            result = isPalindromeRecursive(b, tail.next);
        }
        if (result && b.n.val == tail.val) {
            b.n = b.n.next;
            return true;
        } else {
            return false;
        }

    }

    public class Box {
        ListNode n;
        Box(ListNode n) {this.n = n;}
    }
}
