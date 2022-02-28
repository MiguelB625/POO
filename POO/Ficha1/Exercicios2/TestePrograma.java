package Ficha1.Exercicios2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Ficha1 f = new Ficha1();

        /*// Pergunta 1
        System.out.println("Insira temperatura em Celsius: ");
        Double tempCelsius = sc.nextDouble();
        Double tempFarenheit = f.celsiusParaFarenheit(tempCelsius);
        System.out.println("Temperatura em Farenheit: " + tempFarenheit);

        // Pergunta 2
        System.out.println("Insira dois inteiros: ");
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        System.out.println("O maior é " + f.maximoNumeros(x1, x2));

        // Pergunta 3
        System.out.println("Insira nome e saldo");
        String nome = sc.nextLine();
        float saldo = sc.nextFloat();
        String str = f.criaDescricaoConta(nome, saldo);
        System.out.println("Resposta =" + str);*/

        // Pergunta 4

        // Pergunta 5

        // Pergunta 6
        System.out.println("Factorial de " + args[0] + " é " + f.factorial(Integer.parseInt(args[0])));

        // Pergunta 7
        System.out.println("Data e hora do sistema: ");
        LocalDateTime time = LocalDateTime.now();
        String data = time.toString();
        int hour = time.getHour();
        System.out.println("Data atual: " + data);
        System.out.println("Hora do dia: " + hour);

        System.out.println("Factorial de 5000: " + f.factorial(5000));
    }
}
