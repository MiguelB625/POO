package Ficha1.Exercicios1;

import java.util.Scanner;

public class Exercicio1 {

    public static int dias_do_mes(int mes){
        switch (mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 2: return 28;
            default: return 30;
        }
    }

    public static int calcula_dia_semana(int ano, int mes, int dia){
        int total_dias;
        total_dias = (ano-1900)*365;
        total_dias += (ano-1900)/4;
        if (ano % 4 == 0 && (mes == 1 || mes == 2)) total_dias--;
        for(int i=1; i<mes; i++){
            total_dias += dias_do_mes(i);
        }
        total_dias += dia;

        int resto = total_dias % 7;
        return resto;
    }

    public static void main(String[] args){
        int ano, mes, dia;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite uma data: Ano, Mes, Dia");
        ano = s.nextInt();
        mes = s.nextInt();
        dia = s.nextInt();


        System.out.printf("%d\n", calcula_dia_semana(ano, mes, dia));
    }
}
