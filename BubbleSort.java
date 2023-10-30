/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesort;

import java.util.Random;


public class BubbleSort {
    
    static int nr_trocas = 0;


    public static void main(String[] args) {
        
     long startTime = System.nanoTime();
        
        Random random = new Random(123456789);
        
        int tamanho = 10000;

        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(20000);
        }

        System.out.print("Desordenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }

        ordenarBubble(vetor, tamanho);

        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.print("Numero de trocas: " + nr_trocas + "\n\n");
    }

    public static void ordenarBubble(int[] array, int tamanho) {
        boolean trocado;
        do {
            trocado = false;
            for (int i = 1; i < tamanho; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i]; 
                    array[i] = temp;
                    trocado = true;
                   
                }
            }
            tamanho--;
            nr_trocas += 1;
        } while (trocado);
        
    }
    
}
