package Ficha1.Exercicios1;

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Exercicio6 {
    /**
     * Verifica se um número é primo ou não
     * ( Não usa algoritmo de erastótenes )
     * @param num Número a verificar
     * @return True se for primo, False caso contrário
     */
    public static boolean ePrimo(int num){
        boolean ePrimo = true;
        for(int i=2; i<=sqrt(num); i++){
            ePrimo = ePrimo && (num % i) != 0;
        }
        return ePrimo;
    }
    public static void imprimePrimosAte(int num){
        for(int i=1; i<num; i++){
            if (ePrimo(i)){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int querJogarNovamente = 1;

        while (querJogarNovamente == 1){
            System.out.println("Insira um nº: ");
            int num = sc.nextInt();
            System.out.println("Números primos até " + num);
            imprimePrimosAte(num);
            System.out.println("Quer jogar novamente? S - 1/N - 0");
            querJogarNovamente = sc.nextInt();
        }
    }
}
