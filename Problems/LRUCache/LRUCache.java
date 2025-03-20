package Problems.LRUCache;

import java.security.Key;
import java.util.HashMap;

class Node {
    int value;
    Node next;
    Node prev;
    int key;

    Node(int key, int v) {
        this.key = key;
        this.value = v;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    HashMap<Integer, Node> cache;
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    LRUCache(int c) {
        this.capacity = c;
        this.cache = new HashMap<>();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    void deleteNode(Node delNode) {
        Node prev = delNode.prev;
        Node next = delNode.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            int val = n.value;
            cache.remove(key);

            deleteNode(n);
            addNode(n);
            cache.put(key, head.next);
            return val;

        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node current = cache.get(key);
            cache.remove(key);
            deleteNode(current);
        }

        if (cache.size() == capacity) {
            cache.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        Node node = new Node(key, value);
        addNode(node);
        cache.put(key, head.next);
    }

    public void print() {
        Node temp = head;
        System.out.println("-------------------");
        while (temp != null) {
            System.out.println("Key: " + temp.key + " Value: " + temp.value);
            temp = temp.next;
        }
    }
}

class Cache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(0, 0);
        cache.put(2, 10);
        cache.put(4, 11);
        cache.print();
        cache.put(33, 11);
        cache.put(44, 11);
        cache.put(3, 12);
        System.out.println(cache.get(0));
        cache.print();
    }
}