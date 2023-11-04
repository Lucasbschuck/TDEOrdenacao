package quicksort;

import java.util.Random;

public class QuickSort {    
    static int nr_trocas = 0;
    static int nr_interacao = 0;

    public static void quickSort(int x[], int n) {
        

        int i, k, y;

        for (k = 1; k < n; k++) {
            y = x[k];
            for (i = k - 1; i >= 0 && y < x[i]; i--){
                x[i + 1] = x[i];
                nr_trocas++;
                nr_interacao++;
            }
            nr_interacao++;
            x[i + 1] = y;
        }
    } 

    public static void main(String[] args) {
        
        
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
        long startTime = System.nanoTime();
        quickSort(vetor, tamanho);
        long endTime = System.nanoTime();
        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        
        long duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.println("Numero de trocas: " + nr_trocas);
        System.out.print("Numero de interacoes: " + nr_interacao + "\n\n");
    }        
}
