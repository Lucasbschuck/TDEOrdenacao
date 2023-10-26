package quicksort;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {    

    public static void insercao(int x[], int n){
            
        int i, k, y;

        for (k = 1; k < n; k++){
            y = x[k];
            for(i = k-1; i >= 0 && y < x[i]; i--)
                x[i+1] = x[i];
                x[i+1] = y;
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

        insercao(vetor, tamanho);

        System.out.print("\nOrdenado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }        
}
