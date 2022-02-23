package Exercicios2;

import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Ficha1 f = new Ficha1();

        // Pergunta 3

        System.out.println("Insira nome e saldo");
        String nome = sc.nextLine();
        float saldo = sc.nextFloat();
        String str = f.criaDescricaoConta(nome, saldo);
        System.out.println("Resposta =" + str);
    }
}
