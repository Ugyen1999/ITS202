class linklist {
	Node front;
	Node tail;
	int size;

	//Constructor
	public linklist() 
    {
		front = null;
		tail = null;
		size = 0;
	}

    //Add element e to the back of the Queue Q
	public void enqueue(int e) 
    {
		Node newest = new Node(e, null);
		if(size == 0) 
        {
			front = newest;
			tail = newest;
			System.out.println("Enqueue " +e);
		}
		else {
			tail.setNext(newest);
			tail = newest;
			System.out.println("Enqueue " +e);
		}
		size = size + 1;
	}

    //Remove and return the first element from queue Q
	public int dequeue()
    {
		int deletedElement = front.getElement();
		if(isEmpty())
        {
			return 1;
		}
		else
        {
			front = front.getNext();
			size -= 1;
			System.out.println("Dequeue : " +deletedElement);
		}
		return deletedElement;
	}

    //Returns true if queue Q does not contain any elements
	public boolean isEmpty()
    {
		if(size == 0)
        {
			return true;
		}
		return false;
	}

    //Return a reference to the front of the queue Q, without removing it; an error occurs if the queue is empty
	public int printFrontElement() 
    {
		int frontElement = front.getElement();
		if(size == 0) {
			System.out.println("StackUnderFlowError");
		}
		else 
        {
			return frontElement;
		}
		return printFrontElement();
	}

    //Return the number of elements in queue Q
	public int len() 
    {
		if(isEmpty()) 
        {
			return 1;
		}
		return size;
	}
}

class Node{
	//Variable declaration
	private int element;
	private Node next;
	//constructor
	public Node(int element, Node next) 
    {
		this.element = element;
		this.next = next;
	}
	//getElement
	public int getElement() 
    {
		return element;
	}
	//getNext
	public Node getNext() 
    {
		return next;
	}
	//setElement
	public void setElement(int e) 
    {
		element = e;
	}
	//setNext
	public void setNext(Node e) 
    {
		next = e;
	}
}
public class Question2LinkedList
{

	public static void main(String[] args) 
    {
		linklist obj = new linklist();
		obj.enqueue(8);
		obj.enqueue(4);
		obj.enqueue(5);
		obj.enqueue(6);
		obj.dequeue();
		assert(obj.isEmpty() == false);
		assert(obj.printFrontElement() == 4);
		assert(obj.len() == 3);
		System.out.println("The first element of stack is : " +obj.printFrontElement());
		System.out.println("All are successfully tested!");
	}
}
