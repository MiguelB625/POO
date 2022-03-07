package Ficha3;

import java.util.Objects;

public class Ponto {
    private double x;
    private double y;

    public Ponto(){
        this.x = 0;
        this.y = 0;
    }

    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Ponto(Ponto p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return Double.compare(ponto.x, x) == 0 && Double.compare(ponto.y, y) == 0;
    }

    public Ponto clone(){
        return new Ponto(this);
    }
}
