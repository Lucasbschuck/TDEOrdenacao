package ShellSort;

import java.util.Random;
import java.util.Scanner;

public class ShellSort {
	static int nr_trocas = 0;
	static int length(int arr[]) {
		int count = 0;
		for (int i : arr) {
			count++;
		}
		return count;
	}

	public static void shellSort(int[] vetor) {
		int j, k, y;
		int n = length(vetor);
		int h = 1;
		while (h <= n / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (j = h; j < n; j++) {
				y = vetor[j];
				for (k = j - h; k >= 0 && y < vetor[k]; k -= h) {
					vetor[k + h] = vetor[k];
				}
				nr_trocas += 1;
				vetor[k + h] = y;
			}
			System.out.print("Incremento " + h + ": ");
			h = (h - 1) / 3;
		}
	}

	private static void print(int[] array) {
		
		for (int i : array) {
			System.out.print(i + " ");
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
        shellSort(array);
        System.out.print("\nOrdenado: ");
        print(array);
		
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.print("Numero de trocas: " + nr_trocas + "\n\n");
	}
}
