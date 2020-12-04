import java.util.Scanner;
public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		Scanner obj1 = new Scanner(System.in);
		System.out.print("Enter the size of the array you want to create : ");
		int length = obj1.nextInt();
		int Array[] = new int[length];
		for(int i = 0; i < length; i++) {
			System.out.print("Enter the elements of the Array : ");
			int element = obj1.nextInt();
			Array[i] = element;
		}
		System.out.println("Unsorted Elements ");
		for(int j : Array) {
			System.out.print(j + " ");
		}
		System.out.println();
		obj.Sort(Array);
		obj.printSort(Array);
	}
	public void Sort(int []Array) {
		int n = Array.length;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i -1; j++) {
				if(Array[j] > Array[j + 1]) {
					int temp = Array[j];
					Array[j] = Array[j + 1];
					Array[j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if(Array[j] < Array[j - 1]) {
					int temp = Array[j];
					Array[j] = Array[j -1];
					Array[j - 1] = temp;
				}
			}
		}
	}
	public void printSort(int [] Array) {
		int n = Array.length;
		System.out.println("Sorted Elements ");
		for(int i : Array) {
			System.out.print(i + " ");
		}
	}
}
