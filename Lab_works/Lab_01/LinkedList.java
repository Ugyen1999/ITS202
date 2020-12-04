public class LinkedList{
	Node head;
	Node tail;
	int size;

	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	//Returns the number of elements in the list
	public int size(){
		return size;
	}

	//Returns true if the list is empty if not false
	public boolean isEmpty(){
		if (size == 0) {
			return true;
		}
		return false;
	}

	//Returns (but does not remove) the first element in the list
	public int first(){
		return head.getElement();
	}

	//Returns (but does not remove) the last element in the list
	public int last(){
		return tail.getElement();
	}

	//Adds a new element to the front of the list
	public void addFirst(int n){
		Node newest = new Node(n, null);

		if (size == 0) {
			 head = newest;
			 tail = newest;
		}

		else{
			newest.setNext(head);
			head = newest;
		}
		size = size + 1;
	}

	//Adds a new element to the end of the list
	public void addLast(int n){
		Node newest = new Node(n, null);
		if (size == 0) {
			head = newest;
			tail = newest;
		}
		else{
			tail.setNext(newest);
			tail =newest;
		}
		size += 1;
	}

	//Removes and returns the first element of the list
	public int removeFirst(){
		int deletedElement = head.getElement();
		if (size == 0) {
			return 0;
		}
		else{
			head = head.getNext();
			size = size -1;
		}
		return deletedElement;
	}



}

class Node{
	private int element;
	private Node next;

	// constructor
	public Node(int element, Node next ){
	    this.element = element;
		this.next = next;
	}

	// getElement
	public int getElement(){
		return element;
	}

	// getNext
	public Node getNext(){
		return next;
	}

	//setElement
	public void setElement(int n){
		element = n;
	}

	//setElement
	public void setNext(Node n){
		next = n;
	}
}