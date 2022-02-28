package Ficha2.Exercicio1;

import java.util.Scanner;

public class Exercicio1 {
    public int min(int [] arr){
        int min = arr[0];

        for(int i=0; i<arr.length; i++){
            if (arr[i] < min) min = arr[i];
        }

        return min;
    }

    public int[] leValores(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Quantos números que ler? ");
        int N = sc.nextInt();
        System.out.printf("Introduza %d números: ", N);
        int [] arr = new int[N];
        for(int i = 0; i<arr.length; i++) arr[i] = sc.nextInt();
        return arr;
    }

    public void imprimeArray(int [] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public int [] comuns(int []arr1, int [] arr2){
        int [] comuns = new int[arr1.length];
        int index=0;

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j< arr2.length; j++){
                if (arr1[i] == arr2[j]){
                    comuns[index++] = arr1[i];
                }
            }
        }
        return comuns;
        // 1 2 3 4
        // 4 3 2 1
    }
}
