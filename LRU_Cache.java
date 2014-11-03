public class LRUCache {
    class Node{
        public int key;
        public int value;
        public Node prev;
        public Node next;
        public Node(){
        }
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = tail = null;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(size == 0 || !map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertHead(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else {
            node = new Node(key, value);
        }
        if (size == capacity) {
            remove(tail);
        }
        insertHead(node);
    }
    
    
    public void insertHead(Node node){
        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size ++;
        map.put(node.key, node);
    }
    
    public void remove(Node node){
        if (size == 0) {
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else if (node == head) {
            head = node.next;
            node.next = null;
            head.prev = null; 
        } else if(node == tail) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
        } else {
            Node before = node.prev;
            Node after = node.next;
            before.next = after;
            after.prev = before;
            node.next = node.prev = null;
        }
        size --;
        map.remove(node.key);
    }
}