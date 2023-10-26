/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package selectionsort;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

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

        ordenarSelecao(vetor, tamanho);

        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
    }

    public static void ordenarSelecao(int[] array, int tamanho) {
        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = array[indiceMenor];
            array[indiceMenor] = array[i];
            array[i] = temp;
        } 
    }
}

