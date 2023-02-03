package by.mich;

import by.mich.util.ListNode;

public class L0160_IntersectionTwoLinkedLists {
    public static void main(String[] args) {
        //4,1,8,4,5
        ListNode head = new ListNode(1,
            new ListNode(8,
                new ListNode(4,
                    new ListNode(5))));
        ListNode headA = new ListNode(
            4,head
        );
        ListNode headB = new ListNode(
            5,
            new ListNode(6, head)
        );
        System.out.println(getIntersectionNode(headA, headB));
    }

    // https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/890709392/
    // 98 68
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode i = headA;
        while (i != null) {
            i = i.next;
            lenA++;
        }
        i = headB;
        while (i != null) {
            i = i.next;
            lenB++;
        }
        int diff = lenB - lenA;

        ListNode small = headA;
        ListNode big = headB;
        if (diff < 0) {
            small = headB;
            big = headA;
            diff = -diff;
        }
        while (diff > 0) {
            diff--;
            big = big.next;
        }

        while (small != null) {
            if (small == big) {
                return small;
            }
            small = small.next;
            big = big.next;
        }
        return null;
    }
}
