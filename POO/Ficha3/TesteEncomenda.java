package Ficha3;

import java.time.LocalDate;

public class TesteEncomenda {
    public static void main(String[] args) {
        LinhaEncomenda l1 = new LinhaEncomenda("1", "Telemóvel", 500, 1, 0, 0);
        LinhaEncomenda l2 = new LinhaEncomenda("11", "Monitor", 300, 1, 0, 0);

        LinhaEncomenda[] linhasE1 = {l1, l2};

        Encomenda e1 = new Encomenda("Miguel", 100100100, "Arcos", 987, LocalDate.now(), linhasE1, 2);
        System.out.println(e1.toString());
        System.out.println(e1.numeroTotalProdutos());
        System.out.println(e1.existeProdutoEncomenda("11"));
        e1.removeProduto("1");
        System.out.println(e1.toString());
    }

}
