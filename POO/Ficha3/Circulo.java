package Ficha3;

import java.util.Objects;

public class Circulo {
    private double x, y, raio;

    public Circulo(){
        this.x = 0; this.y = 0; this.raio = 1;
    }

    public Circulo(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo c1){
        this.x = c1.getX();
        this.y = c1.getY();
        this.raio = c1.getRaio();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void alteraCentro(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double calculaArea(){
        return Math.PI*Math.pow(raio, 2);
    }

    public double calculaPerimetro(){
        return 2*Math.PI*raio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return circulo.x == x && circulo.y == y && circulo.raio == raio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "x=" + x +
                ", y=" + y +
                ", raio=" + raio +
                '}';
    }

    public Circulo clone(){
        return new Circulo(this);
    }
}
