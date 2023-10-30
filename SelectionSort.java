/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selectionsort;

import java.util.Random;


public class SelectionSort {
    
    static int troca = 0;
    static int interacao = 0;


    public static void main(String[] args) {
        
        
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
        double startTime = System.nanoTime();

        ordenarSelecao(vetor, tamanho);
        
        double endTime = System.nanoTime();

        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        
        double duration = (endTime - startTime) / 1000000;

        System.out.println("\n\nTempo de execucao de insercao: " + duration + " milissegundos");
        System.out.print("Numero de trocas: " + troca + "\n\n");
        System.out.print("Numero de interacoes: " + (interacao) + "\n\n");
    }

    public static void ordenarSelecao(int[] array, int tamanho) {
        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;
            interacao ++;
            for (int j = i + 1; j < tamanho; j++) {
                interacao ++;
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                    troca ++;

                }
            }
            int temp = array[indiceMenor];
            array[indiceMenor] = array[i];
            array[i] = temp;
           
        }
        
    }
    
}