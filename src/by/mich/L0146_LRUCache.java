package by.mich;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows
 * the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists,
 * otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
// https://leetcode.com/problems/lru-cache/submissions/890953367/
// 82 96
public class L0146_LRUCache {
    int capacity;
    Map<Integer, DListNode> data;
    DListNode head;
    DListNode tail;

    class DListNode {
        int key;
        int value;
        DListNode next;
        DListNode prev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>(capacity);
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    private void liftNode(DListNode node) {
        removeNode(node);
        prependNode(node);
    }

    private void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void prependNode(DListNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        DListNode node = data.get(key);
        if (node == null) return -1;

        liftNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        DListNode prevValue = data.get(key);
        if (prevValue != null) {
            liftNode(prevValue);
            prevValue.value = value;
            return;
        }

        DListNode newNode = new DListNode();
        newNode.key = key;
        newNode.value = value;

        if (data.size() >= capacity) {
            DListNode lru = tail.prev;
            removeNode(lru);
            data.remove(lru.key);
        }
        data.put(key, newNode);
        prependNode(newNode);
    }
}
