import java.util.Scanner;
public class Insertionsort{
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int length = c.nextInt();
		int[] array = new int [length];

		for (int i=0; i<length; i++){
			System.out.println("Enter the elements:");
			int a = c.nextInt();
			array[i]=a;
		}

		System.out.println("The unsorted array is:");
		for(int j=0; j<array.length; j++){
			System.out.print(" "+array[j] + " ");
		}
		System.out.print("Sorted array: ");
		
		Insertion(array);
		for(int i:array){
			System.out.print(i+" ");
		}
	}
	public static void Insertion(int arr[]){
		int x = arr.length;
		for(int y=1; y<x; y++){
			int l=arr[y];
			int i=y-1;

			while((i> -1) && arr[i]>l){
				arr[i+1]=arr[i];
				i--;
			}
			arr[i+1]=l;
		}
	}
}