package ShellSort;

import java.util.Random;
import java.util.Scanner;

public class ShellSort {

	static int length(int arr[]) {
		int count = 0;
		for (int i : arr) {
			count++;
		}
		return count;
	}

	public static void shellSort(int[] vetor) {
		int j, k, increment, y;
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
				vetor[k + h] = y;
			}
			System.out.print("Incremento " + h + ": ");
			print(vetor);
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
		Random rand = new Random(123456789);
		Scanner scan = new Scanner(System.in);
		System.out.println("Tamanho do array: ");
		int tam = scan.nextInt();
		int array[] = new int[tam];

		for (int i = 0; i < tam; i++) {
			array[i] = rand.nextInt(20000);
		}
		shellSort(array);
	}
}
