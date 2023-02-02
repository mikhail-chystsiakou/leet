package by.mich;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class L0707_DesignLinkedList {
    public static void main(String[] args) {
    }

    // https://leetcode.com/problems/design-linked-list/submissions/890013093/
    // 47 74
    static class MyLinkedList {
        private int size = 0;
        private final Node headSentiel;

        public MyLinkedList() {
            headSentiel = new Node(-1, null);
        }

        public int get(int index) {
            if (!validateIndex(index)) return -1;

            Node node = getNode(index);

            return node.val;
        }

        public void addAtHead(int val) {
            Node newHead = new Node(val, headSentiel.next);
            headSentiel.next = newHead;

            size++;
        }

        public void addAtTail(int val) {
            Node prev = getNode(size-1);

            prev.next = new Node(val, null);

            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;


            Node prev = getNode(index-1);

            Node newNode = new Node(val, prev.next);
            prev.next = newNode;

            size++;
        }

        public void deleteAtIndex(int index) {
            if (!validateIndex(index)) return;

            Node prev = getNode(index-1);

            prev.next = prev.next.next;
            size--;
        }

        private boolean validateIndex(int index) {
            return index >= 0 && index < size;
        }

        /** Assumes that index is valid
         */
        private Node getNode(int index) {
            Node node = headSentiel;
            while (index-- >= 0) node = node.next;

            return node;
        }

        private class Node {
            int val;
            Node next;
            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }
    }

}
