public class Question2ArrayTest{
	public static void main(String []args)
	{
		Question2Array obj=new Question2Array(4);
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(4);
		obj.enqueue(5);
		System.out.println(obj.len());
		System.out.println(obj.first());
		System.out.println(obj.isEmpty());
		System.out.println(obj.dequeue());
	


	}
}