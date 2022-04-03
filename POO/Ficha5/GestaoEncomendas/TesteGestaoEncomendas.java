package Ficha5.GestaoEncomendas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TesteGestaoEncomendas {

    public static void main(String[] args) {
        LinhaEncomenda l1 = new LinhaEncomenda("1", "Telemóvel", 500, 1, 0, 0);
        LinhaEncomenda l2 = new LinhaEncomenda("11", "Monitor", 300, 1, 0, 0);
        LinhaEncomenda l3 = new LinhaEncomenda("111", "Monitor", 300, 1, 0, 0);

        List<LinhaEncomenda> ls1 = new ArrayList<>();
        ls1.add(l1);
        ls1.add(l2);

        Encomenda e1 = new Encomenda("Miguel", 100100100, "Arcos", 987, LocalDate.now(), ls1);

        List<LinhaEncomenda> ls2 = new ArrayList<>();

        ls2.add(l3);
        ls2.add(l2);
        Encomenda e2 = new Encomenda("Miguel", 100100100, "Arcos", 997, LocalDate.now(), ls2);


        GestaoEncomendas t = new GestaoEncomendas();
        t.addEncomenda(e1);
        t.addEncomenda(e2);

        // v

        System.out.println(t.encomendaComMaisProdutos());

        // vi

        Set<Integer> setProds = t.encomendasComProduto("11");
        System.out.println(setProds);

        // vii
        LocalDate dataTeste = LocalDate.of(2022, 03, 29);

        Set<Integer> set2 = t.encomendasAposData(dataTeste);
        System.out.println(set2);

        // viii

        System.out.println(e1.calculaValorTotal());
        System.out.println(e2.calculaValorTotal());

        Set<Encomenda> set3 = t.encomendasValorDecrescente();
        System.out.println(set3);

        // ix
        Map<String,List<Integer>> test = t.encomendasDeProduto();
        System.out.println(test);


    }



}
