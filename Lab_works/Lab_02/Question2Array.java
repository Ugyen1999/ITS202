public class Question2Array
{
	int queueArray [];
	int front;
	int len;
	int first;
	int rear;

	public Question2Array(int e)
	{
		front=0;
		len=0;
		rear=0;
		first=-1;
		queueArray=new int[e];

	}
	public void enqueue(int e)
	{
		if (isEmpty())
		{
			queueArray[0]=e;
			front=0;
			rear=0;
			first=queueArray[0];
		}
		else{
			queueArray[rear +1]=e;
			rear = rear+1;
		}
		len=len+1;
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			return 0;
		}
		else{
			front=front +1;
		}
		len=len-1;
		return queueArray[front-1];

	}
	
	public int first()
	{
		if(len==0)
		{
			return 0;
		}
		else
		{
			return queueArray[front];
		}
	}

	public int len()
	{
		return len;
	}

	public boolean isEmpty()
	{
		if (len==0)
		{
			return true;
		}
		return false;
	}
}