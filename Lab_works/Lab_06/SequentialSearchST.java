public class SequentialSearchST<Key, Value> {
	Node head;
	Node tail;
	int size;
    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {
    	head = null;
    	tail = null;
    	size = 0;
    }
    class Node{
    	private Key key;
    	private Value value;
    	private Node next;
    	public Node(Key key, Value value, Node next) {
    		this.key = key;
    		this.value = value;
    		this.next = next;
    	}
    	public Key getKey() {
    		return key;
    	}
    	public Value getValue() {
    		return value;
    	}
    	public Node getNext() {
    		return next;
    	}
    	public void setKey(Key n) {
    		key = n;
    	}
    	public void setValue(Value n) {
    		value = n;
    	}
    	public void setNext(Node n) {
    		next = n;
    	}
//		public String toString() {
//			return key + " - " + value;
//		}
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
    	return size;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
    	if(size == 0) {
    		return true;
    	}
    	return false;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
    	if(key == null) {
    		throw new IllegalArgumentException ("The key doesnot have value");
    	}
    	else {
    		return get(key) != null;
    	}
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
    	if(key == null) {
    		throw new IllegalArgumentException("The key doesnot have value");
    	}
    	for(Node i = head; i != null; i = i.next) {
    		if(key == i.key) {
    			return i.value;
    		}
    	}
    	return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
    	Node newest = new Node(key,val,null);
    	if(size == 0) {
    		head = newest;
    		tail = newest;
    	}
    	else {
    		for(Node i = head; i != null; i = i.next) {
    			if(key == i.key) {
    				i.value = val;
    				return;
    			}
    		}
    		newest.setNext(head);
        	head = newest;
    	}
    	size = size + 1;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
    	 if (key == null) {
    		 throw new IllegalArgumentException("argument to delete() is null"); 
    	 }
    	 else {
    		 head = delete(head, key);
    	 }
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
    	if(x == null) {
    		return null;
    	}
    	else if(key == x.key) {
    		
    		size = size - 1;
    		return x.next;
    	}
    	else {
    		x.next = delete(x.next, key);
    		return x;
    	}
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the for each notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public void traversal(Node head) {
    	Node curNode = head;
    	while(curNode != null) {
    		System.out.println(curNode.key + " has a value " + curNode.value);
    		curNode = curNode.getNext();
    	}
    }
    /**
         main method
     */
    public static void main(String[] args) {
        SequentialSearchST <Integer, String> obj = new SequentialSearchST<Integer, String>();
        obj.put(49, "Dorji");
        obj.put(41, "Anisha");
        obj.put(42, "Vikram");
        obj.put(50, "Yangzom");
        obj.put(47, "Dema");
        obj.delete(49);
        assert(obj.size == 4);
        assert(obj.contains(49) == true);
        assert(obj.contains(71) == false);
        assert(obj.isEmpty() == false);
        obj.traversal(obj.head);
        System.out.println("All test are Correct");
    }
}