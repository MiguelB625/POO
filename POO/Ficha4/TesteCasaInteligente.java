package Ficha4;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Set;

public class TesteCasaInteligente {
    public static void main(String[] args) {
        Lampada l1 = new Lampada();
        Lampada l2 = new Lampada();
        Lampada l3 = new Lampada();
        Lampada l4 = new Lampada();
        l2.setConsumoTotal(100);
        l3.setConsumoTotal(200);
        l4.setConsumoTotal(300);

        ArrayList<Lampada> minhasLampadas = new ArrayList<>();
        minhasLampadas.add(l1);
        minhasLampadas.add(l2);
        minhasLampadas.add(l3);
        minhasLampadas.add(l4);

        CasaInteligente c = new CasaInteligente(minhasLampadas);
        //System.out.println(c);
        Set<Lampada> s = c.podiumEconomia();
        System.out.println(s);

        c.reset();
        System.out.println(c);
    }
}
