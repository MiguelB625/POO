package Ficha1.Exercicios1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza duas datas: ");
        String str_data1 = sc.nextLine();
        String str_data2 = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime data1 = LocalDateTime.parse(str_data1, formatter);
        LocalDateTime data2 = LocalDateTime.parse(str_data2, formatter);

        //LocalDateTime soma = data1+data2;
    }
}
