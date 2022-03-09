package Ficha3;

public class TesteTelemovel {
    public static void main(String[] args) {
        String nomes[] = new String[3];
        Telemovel t1 = new Telemovel("OnePlus", "Nord", 2400, 1080, 100, 100, 100, 100, 10, 0, 2, nomes);
        Telemovel t2 = new Telemovel();
        Telemovel t3 = new Telemovel(t1);

        System.out.println("T1: " + t1.toString());
        System.out.println("T2: " + t2.toString());
        System.out.println("T3: " + t3.toString());
        System.out.println("T1 é igual a T3: " + t1.equals(t3));

    }
}
