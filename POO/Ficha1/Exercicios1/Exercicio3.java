package Ficha1.Exercicios1;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = 0, second = 0, third = 0, fourth = 0;

        while (sc.hasNext() == true){
            double num = sc.nextDouble();
            if (num >= 0 && num < 5) first++;
            else if (num >= 5 && num < 10) second++;
            else if (num >= 10 && num < 15) third++;
            else if (num >= 15 && num <= 20) fourth++;
        }

        System.out.println("Entre 0 e 5: " + first);
        System.out.println("Entre 5 e 10: " + second);
        System.out.println("Entre 10 e 15: " + third);
        System.out.println("Entre 15 e 20: " + fourth);
    }
}
