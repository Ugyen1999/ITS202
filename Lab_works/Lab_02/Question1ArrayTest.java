public class Question1ArrayTest{
	public static void main(String[] args) {
		Question1Array obj1=new Question1Array();
		obj1.push(1);
		obj1.push(2);
		obj1.push(3);
		
		System.out.println(obj1.isEmpty());
		System.out.println(obj1.size());
		System.out.println(obj1.top());
		System.out.println(obj1.pop());
	}
}