package Ficha2.Exercicio2;

import java.util.Scanner;

public class Exercicio2 {

    public void leNotas(int arr[][]){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i< arr.length; i++){
            System.out.printf("Insira as notas do aluno %d: \n", i);
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public void imprimePauta(int arr[][]){
        for(int i=0; i<arr.length; i++){
            System.out.printf("\nNotas do aluno %d: \n", i);
            for(int j=0; j< arr[i].length; j++){
                System.out.printf("%d ", arr[i][j]);
            }
        }
    }

    public int calculaSoma(int arr[][], int column){
        int sum = 0;
        for(int i=0; i< arr.length; i++){
            sum += arr[i][column];
        }
        return sum;
    }


}
