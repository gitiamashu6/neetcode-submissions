class LRUCache {
    int capacity;
    Map<Integer, ListNode> map = new HashMap<>();

    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    // Remove node from linked list
    private void remove(ListNode node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }

    // Add node at the end = most recently used
    private void addLast(ListNode node) {
        node.prev = tail;
        node.next = null;

        if (tail != null)
            tail.next = node;
        else
            head = node;

        tail = node;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        ListNode node = map.get(key);

        // Move to most recently used position
        remove(node);
        addLast(node);

        return node.value;
    }

    public void put(int key, int value) {
        // Key already exists
        if (map.containsKey(key)) {
            ListNode node = map.get(key);

            node.value = value;

            remove(node);
            addLast(node);

            return;
        }

        // Create new node
        ListNode node = new ListNode(key, value);

        // Add to map and linked list
        map.put(key, node);
        addLast(node);

        // Capacity exceeded
        if (map.size() > capacity) {
            map.remove(head.key);
            remove(head);
        }
    }
}

class ListNode {
    int key;
    int value;

    ListNode prev;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}