package heapsort;

import java.util.Random;

public class HeapSort {
    static int nr_trocas = 0;
    static int nr_interacao = 0;
    
    public static void heapify(int arr[], int tam, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < tam && arr[esquerda] > arr[maior]) {
            maior = esquerda;
            nr_trocas++;
        }

        if (direita < tam && arr[direita] > arr[maior]) {
            maior = direita;
            nr_trocas++;
        }

        if (maior != i) {
            int temp = arr[i];
            arr[i] = arr[maior];
            arr[maior] = temp;
            heapify(arr, tam, maior);
        }
        nr_interacao++;
        
        
    }

    public static void heapSort(int arr[], int tam) {

        for (int i = tam / 2 - 1; i >= 0; i--) {
            heapify(arr, tam, i);
        }

        for (int i = tam - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {

        Random random = new Random(123456789);

        int tamanho = 50;

        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(20000);
        }

        System.out.print("\nDesordenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        double startTime = System.nanoTime();
        heapSort(vetor, tamanho);
        double endTime = System.nanoTime();
        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        
        double duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.println("Numero de trocas: " + nr_trocas);
        System.out.print("Numero de interacoes: " + (nr_interacao+nr_trocas) + "\n\n");
    }
}
