package heapsort;

import java.util.Random;
import java.util.Scanner;

public class HeapSort {

    public static void heapify(int arr[], int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && arr[esquerda] > arr[maior]) {
            maior = esquerda;
        }

        if (direita < n && arr[direita] > arr[maior]) {
            maior = direita;
        }

        if (maior != i) {
            int temp = arr[i];
            arr[i] = arr[maior];
            arr[maior] = temp;
            heapify(arr, n, maior);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(123456789);

        System.out.print("Tamanho do vetor: ");
        int tamanho = scanner.nextInt();

        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(20000);
        }

        System.out.print("Desordenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }

        heapSort(vetor);

        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
