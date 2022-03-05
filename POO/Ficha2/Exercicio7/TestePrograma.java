package Ficha2.Exercicio7;

public class TestePrograma {
    public static void main(String[] args) {
        byte chave [] = new byte [5];
        byte estrelas [] = new byte [2];

        Exercicio7 e = new Exercicio7();
        e.aleatorizaArray(chave, 50);
        e.aleatorizaArray(estrelas, 9);

        e.imprimeArray(chave);
        System.out.println("");
        e.imprimeArray(estrelas);
        System.out.println("");

        System.out.println("Introduza 5 números: ");
        byte chaveUtilizador [] = new byte [5];
        e.leChave(chaveUtilizador);

        System.out.println("Introduza 2 estrelas: ");
        byte estrelasUtilizador [] = new byte [2];
        e.leChave(estrelasUtilizador);

        byte numerosCoincidentes [] = e.comparaAposta(chave, chaveUtilizador);
        byte estrelasCoincidentes [] = e.comparaAposta(estrelas, estrelasUtilizador);

        System.out.println("Numeros coincidentes: ");
        e.imprimeArray(numerosCoincidentes);

        System.out.println("Estrelas coincidentes: ");
        e.imprimeArray(estrelasCoincidentes);

        if (numerosCoincidentes.length == 5 && estrelasCoincidentes.length == 2){
            System.out.println("\nGanhou!!");
            int pad=0;
            for(int i=0; i<50; i++){
                for(int j=0; j<pad; j++){
                    System.out.print(" ");
                }
                e.imprimeArray(chave);
                pad += 2;
                System.out.println("");
            }
        }
    }
}
