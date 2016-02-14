__author__ = 'hs634'

class Node(object):
    def __init__(self, key, value):
        self.key = key
        self.val = value
        self.prev, self.next = None, None

class LinkedListCache(object):
    def __init__(self):
        self.head, self.tail = None, None

    def remove(self, node):
        if not node:
            return
        if node.prev is None:
            self.head = node.next
        else:
            node.prev.next = node.next

        if node.next is None:
            self.tail = node.prev
        else:
            node.next.prev = node.prev

    def set_head(self, node):
        node.pre = None
        node.next = self.head

        if self.head is not None:
            self.head.prev = node

        self.head = node

        if self.tail is None:
            self.tail = self.head

    def remove_last(self):
        self.remove(self.tail)


class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.map = {}
        self.cache = LinkedListCache()

    def get(self, key):
        """
        :rtype: int
        """
        if key in self.map:
            node = self.map.get(key)
            self.cache.remove(node)
            self.cache.set_head(node)
            return node.val
        return -1

    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if key in self.map:
            old = self.map[key]
            old.val = value
            self.cache.remove(old)
            self.cache.set_head(old)
        else:
            node = Node(key, value)
            if len(self.map) >= self.capacity:
                self.map.pop(self.cache.tail.key)
                self.cache.remove_last()

            self.cache.set_head(node)
            self.map[key] = node


'''
public class LRUCache {
    int capacity;
    Node head = new Node(-1, -1);  // dummy
    Node tail = new Node(-1, -1);  // dummy
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        join(head, tail);
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n = map.get(key);
        moveToHead(n);
        return n.val;
    }

    public void set(int key, int value) {
        Node n = null;
        if(!map.containsKey(key)) {
            if(map.size() == capacity) removeOldest();
            n = new Node(key, value);
            map.put(key, n);
        } else {
            n = map.get(key);
            n.val = value;
        }
        moveToHead(n);
    }

    public void moveToHead(Node n) {
        if(n.prev != null) disjoin(n);
        Node first = head.next;
        join(head, n);
        join(n, first);
    }

    public void removeOldest() {
        Node last = tail.prev;
        disjoin(last);
        map.remove(last.key); // only delete here
    }

    public void join(Node n1, Node n2) { n1.next = n2; n2.prev = n1; }
    public void disjoin(Node n) { n.prev.next = n.next; n.next.prev = n.prev; }

    class Node {
        int key, val;
        Node prev, next;
        public Node(int k, int v) { key = k; val = v; }
    }
}
'''