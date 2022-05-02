import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        Node next, prev;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        headNext.prev = node;
        node.next = headNext;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

}
