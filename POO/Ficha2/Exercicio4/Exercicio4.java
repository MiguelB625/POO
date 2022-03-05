package Ficha2.Exercicio4;

import java.util.Arrays;

public class Exercicio4 {
    private int arr[];

    public Exercicio4(int size){
        this.arr = new int[size];
    }
    public Exercicio4(int arr[]){
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }
    public String toString(){
        return Arrays.toString(this.arr);
    }

    public void ordenar(){
        Arrays.sort(this.arr);
    }

    public boolean procuraBinaria(int num){
        int esq=0, dir=this.arr.length-1;
        boolean found=false;
        while (esq < dir && !found){
            int meio = (esq + dir)/2;
            if (arr[meio] == num){
                found = true;
            }
            else if (arr[meio] < num){
                esq = meio+1;
            }
            else {
                dir = meio-1;
            }
        }
        return found;
    }
}
