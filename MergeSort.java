
package mergesort;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author lucas
 */
public class MergeSort {
static int interacao = 1;
static int troca = 1;
public static int[] merge(int vetor[] , int tam) {
    if(tam == 1){interacao++;return vetor;}
    int meio = (tam + 1) / 2;
    int A[] = new int[meio];
    int B[] = new int[tam - meio];
    int j = 0;
    int k = 0;

    for (int i = 0; i < tam; i++) {
        if (i < meio) {
            A[j] = vetor[i];
            j++;
        } else {
            B[k] = vetor[i];
            k++;
        }
        interacao++;
    }
    if(meio==1){

        if (A[0] < B[0]) {
            vetor[0] = A[0];
            vetor[1] = B[0];
        } else {
            vetor[0] = B[0];
            vetor[1] = A[0];
        }
        troca++;
        return vetor;
    }
    
    else {
        A = merge(A,meio);
        B = merge(B,(tam-meio));
        
    }
    j = 0;
    k = 0;
    for (int i = 0; i < tam; i++) {
        if(j>=meio){
            vetor[i] = B[k];
            k++;}
        else if(k>=tam-meio){
            vetor[i] = A[j];
            j++;     
        }
        else if (A[j]<B[k]) {
            vetor[i] = A[j];
            j++;
            troca++;
        } 
        else{
            vetor[i] = B[k];
            k++;
            troca++;
        }
        interacao++;
        }
    interacao++;
    return vetor;
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
    
    vetor = merge(vetor, tamanho);

    System.out.print("\nOrdenado: ");
    for (int num : vetor) {
        System.out.print(num + " ");
    }
    System.out.print("\nTrocas: "+troca);
    System.out.print("\nInteracao: "+interacao);
    scanner.close();
    }        
}