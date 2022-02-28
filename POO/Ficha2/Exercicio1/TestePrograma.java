package Ficha2.Exercicio1;

import java.util.Arrays;

public class TestePrograma {
    public static void main(String[] args) {
        Exercicio1 e = new Exercicio1();

        int arrInts[] = e.leValores();
        System.out.println("Primeiro array...");
        e.imprimeArray(arrInts);

        System.out.println("O mínimo deste array é " + e.min(arrInts));

        int arrInts2[] = e.leValores();
        System.out.println("Segundo array...");
        e.imprimeArray(arrInts2);

        System.out.println("Array dos comuns...");
        int comuns[] = e.comuns(arrInts, arrInts2);
        e.imprimeArray(comuns);
    }

}
