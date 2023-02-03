package by.mich;

import by.mich.util.ListNode;

public class L0019_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Pair p = removeNthFromEndRecursive(head, n, 0);

        return p.prev;
    }

    public static Pair removeNthFromEndRecursive(ListNode head, int n, int i) {
        if (head.next == null) {
            return new Pair(null, 1);
        }

        Pair p = removeNthFromEndRecursive(head.next, n, i+1);
        if (p.n == n) {
            p.prev = head;
        }
        if (i > 0) {
            p.n++;
            return p;
        }

        if (p.prev == null) {
            return new Pair(head.next, p.n);
        } else {
            p.prev.next = p.prev.next.next;
            return new Pair(head, p.n);
        }
    }

    public static class Pair {
        ListNode prev;
        int n;

        public Pair(ListNode prev, int n) {
            this.prev = prev;
            this.n = n;
        }
    }
}
