package Ficha3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Encomenda {
    private static int tamanho = 16;
    private String nome;
    private long numeroCliente;
    private String morada;
    private long numeroEncomenda;
    private LocalDate data;
    private LinhaEncomenda[] linhas;
    private int occupied;

    // Métodos Usuais

    public Encomenda(String nome, long numeroCliente, String morada, long numeroEncomenda, LocalDate data, LinhaEncomenda[] linhas, int occupied) {
        this.nome = nome;
        this.numeroCliente = numeroCliente;
        this.morada = morada;
        this.numeroEncomenda = numeroEncomenda;
        this.data = data;
        this.linhas = new LinhaEncomenda[Encomenda.tamanho];

        if (occupied < Encomenda.tamanho){
            this.occupied = linhas.length;
            System.arraycopy(linhas, 0, this.linhas, 0, linhas.length);
        }


    }

    public Encomenda() {
        this.nome = "";
        this.numeroCliente = 0;
        this.morada = "";
        this.numeroEncomenda = 0;
        this.data = LocalDate.now();
        linhas = null;
    }

    public Encomenda(Encomenda e){
        this.nome = e.getNome();
        this.numeroCliente = e.getNumeroCliente();
        this.morada = e.getMorada();
        this.numeroEncomenda = e.getNumeroEncomenda();
        this.data = e.getData();
        this.linhas = new LinhaEncomenda[e.getLinhas().length];
        System.arraycopy(e.getLinhas(), 0, this.linhas, 0, e.getLinhas().length);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Encomenda{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", numeroCliente=").append(numeroCliente);
        sb.append(", morada='").append(morada).append('\'');
        sb.append(", numeroEncomenda=").append(numeroEncomenda);
        sb.append(", data=").append(data);
        sb.append(", linhas=").append(Arrays.toString(linhas));
        sb.append('}');
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public long getNumeroEncomenda() {
        return numeroEncomenda;
    }

    public void setNumeroEncomenda(long numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LinhaEncomenda[] getLinhas() {
        return linhas;
    }

    public void setLinhas(LinhaEncomenda[] linhas) {
        System.arraycopy(this.linhas, 0, linhas, 0, linhas.length);
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return numeroCliente == encomenda.numeroCliente && numeroEncomenda == encomenda.numeroEncomenda && Objects.equals(nome, encomenda.nome) && Objects.equals(morada, encomenda.morada) && Objects.equals(data, encomenda.data) && Arrays.equals(linhas, encomenda.linhas);
    }

    // Outros métodos

    /**
     * Soma do valor de todas as linhas de encomenda
     * @return
     */
    public double calculaValorTotal(){
        double valorTotal=0.0;

        for(int i=0; i< this.occupied; i++){
            valorTotal += linhas[i].calculaValorLinhaEnc();
        }

        return valorTotal;
    }

    /**
     * Soma dos valores de desconto de todas as linhas de encomenda
     * @return
     */
    public double calculaValorDesconto(){
        double valorDesconto=0.0;

        for(int i=0; i<this.occupied; i++){
            valorDesconto += linhas[i].calculaValorDesconto();
        }

        return valorDesconto;
    }

    /**
     * Número total de produtos encomenadados
     * @return
     */
    public int numeroTotalProdutos(){
        int numProds=0;

        for(int i=0; i<this.occupied; i++){
            numProds += linhas[i].getQuantidade();
        }

        return numProds;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        boolean existe = false;

        for(int i=0; i<this.occupied && !existe; i++){
            existe = existe || linhas[i].getRefProduto() == refProduto;
        }

        return existe;
    }

    // Melhorar classe sem ter que duplicar array
    public void adicionaLinha(LinhaEncomenda linha){

    }

    public void removeProduto(String codProd){
        for(int i=0; i<this.occupied; i++){
            if (this.linhas[i].getRefProduto() == codProd){
                System.arraycopy(this.linhas, i+1, this.linhas, i, this.occupied-i-1);
                this.linhas[--this.occupied                 ] = null;
            }
        }
    }



}
