package heapsort;

import java.util.Random;

public class HeapSort {
    static int nr_trocas = 0;
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
        nr_trocas += 1;
        
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
        long startTime = System.nanoTime();
        
        Random random = new Random(123456789);

        int tamanho = 10000;

        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(20000);
        }

        System.out.print("\nDesordenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }

        heapSort(vetor);

        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.print("Numero de trocas: " + nr_trocas + "\n\n");
    }
}
