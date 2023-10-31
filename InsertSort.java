/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package insertsort;

import java.util.Random;

public class InsertSort {
    static int nr_trocas = 0;
    static int nr_interacao = 0;
    
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
                    nr_interacao ++;
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
                            nr_interacao ++;
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
        
		Random rand = new Random(123456789);
		int tam = 50;
		
		int array[] = new int[tam];
		for (int i = 0; i < tam; i++) {
			array[i] = rand.nextInt(20000);
		}
		
        System.out.print("\nDesordenado: ");
        print(array);
        double startTime = System.nanoTime();
        sort(array);
        double endTime = System.nanoTime();
        System.out.print("\nOrdenado: ");
        print(array);
        
        
        double duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.print("Numero de trocas: " + nr_trocas + "\n\n");
        System.out.print("Numero de interacoes: " + (nr_interacao) + "\n\n");


	}
}