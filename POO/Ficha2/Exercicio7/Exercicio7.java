package Ficha2.Exercicio7;

import java.util.Scanner;

public class Exercicio7 {
    public void aleatorizaArray(byte array [], int max){
        for(int i=0; i< array.length; i++){
            boolean jaSaiu = false;
            do {
                array[i] = (byte) (Math.random() * max);
                for(int j=0; j<i; j++){
                    if (array[i] == array[j]){
                        jaSaiu = true;
                    }
                }
            } while (jaSaiu);
        }
    }

    public void imprimeArray(byte array[]){
        for(int i=0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public void leChave(byte array[]){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i< array.length; i++){
            array[i] = sc.nextByte();
        }
    }

    public byte[] comparaAposta(byte chave[], byte aposta[]) {
        byte arrInic[] = new byte[5];
        int coinc = 0;

        for (int i = 0; i < aposta.length; i++) {
            boolean encontrou = false;
            for (int j = 0; j < chave.length && !encontrou; j++) {
                if (aposta[i] == chave[j]) {
                    encontrou = true;
                    arrInic[coinc] = aposta[i];
                    coinc++;
                }
            }
        }

        byte arrFinal[] = new byte [coinc];

        for(int i=0; i<coinc; i++){
            arrFinal[i] = arrInic[i];
        }

        return arrFinal;
    }
}
