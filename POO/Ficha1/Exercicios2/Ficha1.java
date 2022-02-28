package Ficha1.Exercicios2;

public class Ficha1 {
    // Exercicio 1
    public double celsiusParaFarenheit(double graus){
        return graus * 1.8 + 32;
    }

    // Exercicio 2
    public int maximoNumeros(int a, int b){
        return a>b ? a : b;
    }
    // Exercicio 3
    public String criaDescricaoConta(String nome, float saldo){
        return "Nome: " + nome + ", saldo: " + saldo;
    }

    // Exercicio 4

    // Exercicio 5

    // Exercicio 6
    public long factorial(int num){
        long fact=1;
        for(int i=2; i<=num; i++){
            fact *= i;
        }

        return fact;
    }

    // Exercicio 7


}
