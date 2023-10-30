/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selectionsort;

import java.util.Random;


public class SelectionSort {
    
    static int nr_trocas = 0;


    public static void main(String[] args) {
        
     long startTime = System.nanoTime();
        
        Random random = new Random(123456789);
        
        int tamanho = 50;

        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(20000);
        }

        System.out.print("Desordenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }

        ordenarSelecao(vetor, tamanho);

        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.print("Numero de trocas: " + nr_trocas + "\n\n");
    }

    public static void ordenarSelecao(int[] array, int tamanho) {
        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                    nr_trocas += 1;

                }
            }
            int temp = array[indiceMenor];
            array[indiceMenor] = array[i];
            array[i] = temp;
           
        }
        
    }
    
}