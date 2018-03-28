class LRUCache {

    // private class for double pointer linkedList 	    
    private class DoubleListNode {
	
		public DoubleListNode prev;
	    public DoubleListNode next;

		private int key;
	    private int val;
	
	    public DoubleListNode (int key, int val) {
			this.key = key;
			this.val = val;
	    }
	}

	DoubleListNode head;
	DoubleListNode tail;
	
	int capacity;
	Map<Integer, DoubleListNode> map;
    
	public void moveToTop(DoubleListNode node) {
		deleteFromList(node);
		addToTop(node);
	}

	public void addToTop (DoubleListNode node) {
		//add to head
		DoubleListNode headNext = head.next;
		node.prev = head;
		node.next = headNext;
		head.next = node;
		headNext.prev = node;
	}

	public void deleteFromList (DoubleListNode node) {
		// delete from the list
		DoubleListNode prev = node.prev;
		DoubleListNode next = node.next;
		prev.next = next;
		next.prev = prev;
	}

    public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, DoubleListNode> ();
		head = new DoubleListNode(0, 0);
		tail = new DoubleListNode(0, 0);
		head.next = tail;
		tail.prev = head;
    }
    
    public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		DoubleListNode choosen = map.get(key);
		moveToTop(choosen);
		return choosen.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
			DoubleListNode choosen = map.get(key);
			choosen.val = value;
			moveToTop(choosen);
			return;
		}
		
		if (map.size() == capacity) { 
			map.remove(tail.prev.key);
			deleteFromList(tail.prev);
		} 
		
		DoubleListNode temp = new DoubleListNode (key, value);
		map.put(key, temp);
		addToTop(temp);	
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
