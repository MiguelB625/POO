package Ficha3;

import java.util.Objects;

public class LinhaEncomenda {
    private String refProduto;
    private String descrProduto;
    private double preço;
    private int quantidade;
    private double imposto;
    private double descComercial;

    public void setRefProduto(String refProduto) {
        this.refProduto = refProduto;
    }

    public void setDescrProduto(String descrProduto) {
        this.descrProduto = descrProduto;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setDescComercial(double descComercial) {
        this.descComercial = descComercial;
    }

    public String getRefProduto() {
        return refProduto;
    }

    public String getDescrProduto() {
        return descrProduto;
    }

    public double getPreço() {
        return preço;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getImposto() {
        return imposto;
    }

    public double getDescComercial() {
        return descComercial;
    }

    public LinhaEncomenda(){
        this.refProduto = "";
        this.descrProduto = "";
        this.preço = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.descComercial = 0;
    }

    public LinhaEncomenda(String refProduto,
                          String descrProduto,
                          double preço,
                          int quantidade,
                          double imposto,
                          double descComercial){
        this.refProduto = refProduto;
        this.descrProduto = descrProduto;
        this.preço = preço;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.descComercial = descComercial;
    }

    public LinhaEncomenda(LinhaEncomenda l){
        this.refProduto = l.getRefProduto();
        this.descrProduto = l.getDescrProduto();
        this.preço = l.getPreço();
        this.quantidade = l.getQuantidade();
        this.imposto = l.getImposto();
        this.descComercial = l.getDescComercial();
    }

    public double calculaValorLinhaEnc(){
        return (this.preço - calculaValorDesconto())*(1-this.imposto)*this.quantidade;
    }

    public double calculaValorDesconto(){
        return this.preço*this.descComercial;
    }

    @Override
    public String toString() {
        return "LinhaEncomenda{" +
                "refProduto='" + refProduto + '\'' +
                ", descrProduto='" + descrProduto + '\'' +
                ", preço=" + preço +
                ", quantidade=" + quantidade +
                ", imposto=" + imposto +
                ", descComercial=" + descComercial +
                '}';
    }

    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaEncomenda that = (LinhaEncomenda) o;
        return Double.compare(that.preço, preço) == 0 && quantidade == that.quantidade && Double.compare(that.imposto, imposto) == 0 && Double.compare(that.descComercial, descComercial) == 0 && Objects.equals(refProduto, that.refProduto) && Objects.equals(descrProduto, that.descrProduto);
    }
}
