package Ficha3;

public class Exercicio7 {
    LinhaEncomenda l1 = new LinhaEncomenda("123", "O meu Produto", 12, 2, 0.06, 0.5);
    LinhaEncomenda l2 = new LinhaEncomenda("123", "O meu Produto", 12, 2, 0.06, 0.5);

    public static void main(String[] args) {
        LinhaEncomenda l1 = new LinhaEncomenda("123", "O meu Produto", 12, 2, 0.06, 0.5);
        LinhaEncomenda l2 = l1.clone();
        System.out.println("Compara l1 e l2: " + l1.equals(l2));
        System.out.println(l2.toString());
        System.out.println("Valor a pagar: " + l1.calculaValorLinhaEnc());

    }
}
