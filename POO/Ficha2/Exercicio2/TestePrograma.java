package Ficha2.Exercicio2;

public class TestePrograma {
    public static void main(String[] args) {
        int [][] notasTurma = new int[5][5];

        Exercicio2 e = new Exercicio2();
        e.leNotas(notasTurma);
        System.out.println("A imprimir a pauta dos alunos: ");
        e.imprimePauta(notasTurma);

        int x = e.calculaSoma(notasTurma, 2);
        System.out.println("A soma das notas dos alunos à UC 2 é " + x);

    }

}
