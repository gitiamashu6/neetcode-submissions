class LRUCache {
    int capacity;
    ListNode head = null;
    ListNode temp = head;
    Map<Integer, ListNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        else {
            ListNode node = map.get(key);
            if (key == temp.key)
                return temp.value;
            if (key == head.key && head.next != null)
                head = head.next;
            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            temp.next = node;
            node.prev = temp;
            temp = node;
            map.put(key, temp);
            return node.value;
        }
    }

    public void put(int key, int value) {
        ListNode node = new ListNode();
        node.key = key;
        node.value = value;
        if (!map.containsKey(key)) {
            if (map.size() < capacity) {
                if (head == null) {
                    head = node;
                    temp = head;
                } else {
                    temp.next = node;
                    node.prev = temp;
                    map.put(temp.key, temp);
                    temp = node;
                }
                map.put(key, temp);
            } else {
                map.remove(head.key);

                if (head.next == null) {
                    head = node;
                    temp = node;
                } else {
                    head = head.next;
                    temp.next = node;
                    node.prev = temp;
                    temp = node;
                }

                map.put(key, temp);
            }
        } else {
            ListNode tempNode = map.get(key);
            if (key == temp.key) {
                temp.value = value;
                map.put(key, temp);
            } else {
                if (key == head.key && head.next != null)
                    head = head.next;
                if (tempNode.prev != null)
                    tempNode.prev.next = tempNode.next;
                if (tempNode.next != null)
                    tempNode.next.prev = tempNode.prev;
                tempNode.prev = null;
                tempNode.next = null;
                temp.next = node;
                node.prev = temp;
                temp = node;
                map.put(key, temp);
            }
        }
    }
}

class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;
    public ListNode() {}
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public ListNode(int key, int value, ListNode prev) {
        this.key = key;
        this.value = value;
        this.prev = prev;
    }
    // public ListNode(int key, int value, ListNode next) {
    //     this.key = key;
    //     this.value = value;
    //     this.next = next;
    // }
    public ListNode(int key, int value, ListNode prev, ListNode next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
