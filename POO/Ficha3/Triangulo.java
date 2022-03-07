package Ficha3;

import java.util.Objects;

public class Triangulo {
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;

    //Erro
    /*public Triangulo(){
        this.p1 = new Ponto();
        this.p2 = new Ponto();
        this.p3 = new Ponto();
    }*/

    public Triangulo(Ponto p1, Ponto p2, Ponto p3){
        this.p1 = p1.clone(); // Clone?
        this.p2 = p2.clone();
        this.p3 = p3.clone();
    }

    public Triangulo(Triangulo t){
        this.p1 = t.p1.clone();
        this.p2 = t.p2.clone();
        this.p3 = t.p3.clone();
    }

    public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3){
        this.p1 = new Ponto(x1, y1);
        this.p2 = new Ponto(x2, y2);
        this.p3 = new Ponto(x3, y3);
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangulo triangulo = (Triangulo) o;
        return p1.equals(triangulo.p1) && p2.equals(triangulo.p2) && p3.equals(triangulo.p3);
    }

    public double calculaAreaTriangulo(){
        // Utilizar fórmula de Heron
        return 0;
    }
}
