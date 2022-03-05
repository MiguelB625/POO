package Ficha2.Exercicio4;

import java.util.Scanner;

public class TestePrograma {
    public static void getNums(int arr[], int size, Scanner sc){
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        // Criação do array
        System.out.println("Qual o tamanho do array? ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];

        // Leitura do array
        System.out.printf("Introduza %d números: ", N);
        getNums(arr, N, sc);

        // Funções do Exercício
        Exercicio4 e = new Exercicio4(arr);
        System.out.println("Print do array antes de ordenar: " + e.toString() );
        e.ordenar();
        System.out.println("Print do array depois de ordenar: " + e.toString() );
        System.out.println("Procura o número 2: " + e.procuraBinaria(2));

    }

}
