package Tde02;

import java.util.Random;

public class QuickSort {    
    static int nr_trocas = 0;
    static int nr_interacao = 0;

	public static void quickSort(int x[], int baixo, int alto) {
        if (baixo < alto) {
        	nr_interacao++;
            int pi = particao(x, baixo, alto);
            quickSort(x, baixo, pi - 1);
            quickSort(x, pi + 1, alto);
        }
    }

    private static int particao(int x[], int baixo, int alto) {
        int pivo = x[alto];
        int i = baixo - 1;
        for (int j = baixo; j < alto; j++) {
        	nr_interacao++;
            if (x[j] < pivo) {
                i++;
                troca(x, i, j);
            }
        }
        troca(x, i + 1, alto);
        return i + 1;
    }

    private static void troca(int x[], int i, int j) {
        int temp = x[i];
        nr_trocas ++;
        x[i] = x[j];
        x[j] = temp;
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
        double startTime = System.nanoTime();
        quickSort(vetor, 0, tamanho - 1);
        double endTime = System.nanoTime();
        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        
        double duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.println("Numero de trocas: " + nr_trocas);
        System.out.print("Numero de interacoes: " + nr_interacao + "\n\n");
    }        
}