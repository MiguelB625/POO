package Ficha3;

public class TesteCirculo {
    public static void main(String[] args) {
        // Teste 1
        Circulo c1 = new Circulo();
        c1.setRaio(2);
        c1.setX(1);
        c1.setY(5);
        System.out.println(c1.toString());

        // Teste 2
        Circulo c2 = new Circulo(2, 3, 3);
        c2.alteraCentro(5,6);
        System.out.println("Perimetro do c2: " + c2.calculaPerimetro());
        System.out.println("Area do c2: " + c2.calculaArea());
        System.out.println(c2.toString());
    }
}
