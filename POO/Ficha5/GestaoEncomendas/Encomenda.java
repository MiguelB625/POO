package Ficha5.GestaoEncomendas;
/*********************************************************************************/
/** DISCLAIMER: Este cÃ³digo foi criado e alterado durante as aulas prÃ¡ticas      */
/** de POO. Representa uma soluÃ§Ã£o em construÃ§Ã£o, com base na matÃ©ria leccionada */
/** atÃ© ao momento da sua elaboraÃ§Ã£o, e resulta da discussÃ£o e experimentaÃ§Ã£o    */
/** durante as aulas. Como tal, nÃ£o deverÃ¡ ser visto como uma soluÃ§Ã£o canÃ³nica,  */
/** ou mesmo acabada. Ã‰ disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos sÃ£o encorajados a testar adequadamente o cÃ³digo fornecido e a      */
/** procurar soluÃ§Ãµes alternativas, Ã  medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;
/**
 * Classe que implementa uma Encomenda (cf exercÃ­cio da Ficha 4).
 *
 * @author MaterialPOO
 * @version 20180323
 *
 * @version 2019029
 * @version 20220324
 */
public class Encomenda implements Comparable<Encomenda>{
    private String nomeCliente;
    private int nif;
    private String morada;
    private int nEnc;
    private LocalDate data;
    private List<LinhaEncomenda> linhas;

    public Encomenda(String nomeCliente, int nif, String morada, int nEnc,
                     LocalDate data, List<LinhaEncomenda> linhasEnc) {
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.nEnc = nEnc;
        this.data = data;
        setEncomendas(linhasEnc);
    }

    public Encomenda() {
        this.linhas = new ArrayList<>();
        this.nomeCliente = "n/a";
        this.nif = 0;
        this.morada = "n/a";
        this.nEnc = 0;
        this.data = LocalDate.now();
    }

    public Encomenda(Encomenda enc) {
        this.linhas = enc.getLinhas();
        this.nomeCliente = enc.getNomeCliente();
        this.nif = enc.getNif();
        this.morada = enc.getMorada();
        this.nEnc = enc.getNEnc();
        this.data = enc.getData();
        //this.data = LocalDate.now();
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public int getNif() {
        return this.nif;
    }

    public String getMorada() {
        return this.morada;
    }

    public int getNEnc() {
        return this.nEnc;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setEncomendas(List<LinhaEncomenda> linhasEnc) {
        this.linhas = new ArrayList<>();
        for(LinhaEncomenda le : linhasEnc) {
            this.linhas.add(le.clone());
        }
    }

    //
    // Uma versÃ£o com iteradores internos:
    //
    // public void setEncomendas(List<LinhaEncomenda> linhasEnc) {
    //   this.linhas = linhasEnc.stream().map(LinhaEncomenda::clone).collect(Collectors.toList());
    // }
    //


    public List<LinhaEncomenda> getLinhas() {
        return this.linhas.stream().map(LinhaEncomenda::clone).collect(Collectors.toList());
    }


    //public List<LinhaEncomenda> getLinhas() {
    //    List<LinhaEncomenda> res = new ArrayList<>();
    //    for(LinhaEncomenda le : this.linhas) {
    //        res.add(le.clone());
    //    }
    //    return res;
    //}

    public Encomenda clone() {
        return new Encomenda(this);
    }

    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        Encomenda e = (Encomenda)o;
        return nomeCliente.equals(e.getNomeCliente()) && nif == e.getNif() &&
                morada.equals(e.getMorada()) && nEnc == e.getNEnc() &&
                data.equals(e.getData()) && this.linhas.equals(e.getLinhas());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomenda : [");
        sb.append("NÃºmero Encomenda: ").append(this.nEnc);
        sb.append("NomeCliente: ").append(this.nomeCliente);
        sb.append("NIF: ").append(this.nif);
        sb.append("Morada: ").append(this.morada);
        sb.append("Data Enc: ").append(this.data);
        sb.append(this.linhas.toString());
        return sb.toString();
    }


    /**
     * B)
     */
    public double calculaValorTotal() {
        double r = 0;
        for(LinhaEncomenda le : this.linhas) {
            r += le.calculaValorLinhaEnc();
        }
        return r;
    }


    /*
     * MÃ©todo de resposta a B) com recurso a iteradores internos.
     */

    public double calculaValorTotal_I() {
        return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }



    /**
     * C)
     */

    public double calculaValorDesconto() {
        return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    /*
     * MÃ©todo que implementa C) com recurso a iteradores externos
     */

    public double calculaValorDesconto_E() {
        double r = 0;
        for(LinhaEncomenda le : this.linhas) {
            r += le.calculaValorDesconto();
        }
        return r;
    }


    /**
     * D)
     */
    public int numeroTotalProdutos() {
        int r = 0;
        for(LinhaEncomenda le : this.linhas) {
            r += le.getQuantidade();
        }
        return r;
    }

    /**
     * E)
     */
    public boolean existeProdutoEncomenda(String codProd) {
        boolean existe = false;
        int i=0;

        while(!existe && i< this.linhas.size()) {
            if(this.linhas.get(i).getReferencia().equals(codProd))
                existe = true;
            i++;
        }
        return existe;
    }


    // codificaÃ§Ã£o alternativa de E) com recurso a iteradores internos
    public boolean existeNaEncomenda(String codProd) {
        return this.linhas.stream().anyMatch(e -> (e.getReferencia()).equals(codProd));
    }


    /**
     * F)
     */
    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhas.add(linha.clone());
    }

    /**
     * G)
     */

    public void removeProduto(String codProd){
        for(Iterator<LinhaEncomenda> it = this.linhas.iterator() ; it.hasNext();){
            LinhaEncomenda le = it.next();
            if(le.getReferencia().equals(codProd)){
                it.remove();
            }
        }
    }

    //calcula o nÃºmero de produtos encomendados nesta encomenda
    public int numProdutos() {

        return this.linhas.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
    }





    //calcula a lista dos produtos de uma encomenda
    public List<String> getListaProdutos() {
        return this.linhas.stream().map(LinhaEncomenda::getReferencia).distinct().collect(Collectors.toList());
    }

    public int compareTo(Encomenda e){
        if (this.calculaValorTotal() > e.calculaValorTotal()) return -1;
        else if (this.calculaValorTotal() < e.calculaValorTotal()) return 1;
        else return 0;
    }
}