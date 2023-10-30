package InsertSort;

import java.util.Random;

public class InsertSort {
    static int nr_trocas = 0;
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
				nr_trocas += 1;
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
        long startTime = System.nanoTime();
		Random rand = new Random(123456789);
		int tam = 10000;
		
		int array[] = new int[tam];
		for (int i = 0; i < tam; i++) {
			array[i] = rand.nextInt(20000);
		}
		
        System.out.print("\nDesordenado: ");
        print(array);
        sort(array);
        System.out.print("\nOrdenado: ");
        print(array);
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.print("Numero de trocas: " + nr_trocas + "\n\n");


	}
}
