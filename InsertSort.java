package InsertSort;

import java.util.Random;
import java.util.Scanner;

public class InsertSort {
	
	 static int length(int arr[]){
		int count = 0;
		for (int i : arr) {
			count++;
		}
		return count;
	}
	
	static void sort(int arr[]) {
		int n = length(arr);
		for (int i = 0; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	
	static void print(int arr[]) {
		int n = length(arr);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Random rand = new Random(123456789);
		Scanner scan = new Scanner(System.in);
		System.out.println("Tamanho do array: "); int tam = scan.nextInt();
		int array[] = new int[tam];
		for (int i = 0; i < tam; i++) {
			array[i] = rand.nextInt(20000);
		}
		print(array);
		sort(array);
		print(array);
	}
}
