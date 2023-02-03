package by.mich;

import by.mich.util.ListNode;

public class L0142_LinkedListCycle2 {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/linked-list-cycle-ii/submissions/890731541/
    // 100 94
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) break;
        }
        if (f == null || f.next == null) {
            return null;
        }
        f = head;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
