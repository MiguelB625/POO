package Ficha4.CasaInteligente;

import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {
    private ArrayList<Lampada> arrLampadas;

    // Getters and Setters
    /**
     * Getter para o array de lampadas
     * @return
     */
    public ArrayList<Lampada> getArrLampadas() {
        // iterador externo: streams
        return (ArrayList<Lampada>) arrLampadas.stream()
                .map(Lampada::clone)
                .collect(Collectors.toList());
    }

    /**
     * Setter para o array de lampadas
     * @param arrLampadas
     */
    public void setArrLampadas(ArrayList<Lampada> arrLampadas) {
        this.arrLampadas.removeAll(arrLampadas);
        for(Lampada l: arrLampadas){
            this.arrLampadas.add(l.clone());
        }
    }

    // Construtores

    /**
     * Construtor default
     */
    public CasaInteligente(){
        arrLampadas = new ArrayList<Lampada>();
    }

    /**
     * Construtor que recebe a lista de lámpadas por argumento
     * @param arrLampadas
     */
    public CasaInteligente(ArrayList<Lampada> arrLampadas) {
        this.arrLampadas = new ArrayList<Lampada>();
        for(Lampada l: arrLampadas){
            this.arrLampadas.add(l.clone());
        }
    }

    public CasaInteligente(CasaInteligente c){
        // Não fazer clone da própria lista porque vai haver partilha de apontadores entre os elementos
        for(Lampada l: c.getArrLampadas()){
            this.arrLampadas.add(l);
        }
    }

    // Métodos essenciais: toString, clone e equals
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CasaInteligente{");
        sb.append("arrLampadas=").append(arrLampadas.toString());
        sb.append('}');
        return sb.toString();
    }

    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CasaInteligente that = (CasaInteligente) o;
        return arrLampadas.equals(that.getArrLampadas());
    }

    // Métodos do exercício
    public void addLampada(Lampada l){
        this.arrLampadas.add(l.clone()); // Estratégia de composição
    }

    /**
     * Liga uma lâmpada em modo normal numa dada posição do array
     * @param index
     */
    public void ligaLampadaNormal(int index){
        if (index < arrLampadas.size())
            this.arrLampadas.get(index).lampON();
    }

    /**
     * Liga uma lâmpada em modo eco numa dada posição do array
     * @param index
     */
    public void ligaLampadaEco(int index){
        if (index < arrLampadas.size()){
            this.arrLampadas.get(index).lampECO();
        }
    }

    /**
     * Determina quantas lâmpadas estão em modo eco
     * @return
     */
    public int qtEmEco(){
        return (int)this.arrLampadas.stream().filter(lampada -> lampada.getModo() == Lampada.Modo.ECO).count();
    }

    /**
     * Remove a lámpada na posição dada
     * @param index
     */
    public void removeLampada(int index){
        Iterator<Lampada> itLampadas = this.arrLampadas.iterator();

        int ind=0;
        while (itLampadas.hasNext()){
            Lampada a = itLampadas.next();
            if (ind == index){
                itLampadas.remove();
            }
             ind++;
        }

    }

    /**
     * Coloca todas as lâmpadas em modo ECO
     */
    public void ligaTodasEco(){
        this.arrLampadas.forEach(lampada -> lampada.lampECO());
    }

    /**
     * " " " ON (MAX)
     */
    public void ligaTodasMax(){
        this.arrLampadas.forEach(lampada -> lampada.lampON());
    }

    public double consumoTotal(){
        double consumoTotal = 0;

        for(Lampada l: this.arrLampadas){
            consumoTotal += l.getConsumoTotal();
        }

        return consumoTotal;
    }

    public Set<Lampada> podiumEconomia(){
        return this.arrLampadas.stream().sorted(Lampada::compareTo).limit(3).collect(Collectors.toSet());
    }

    public void reset(){
        for(Lampada l: this.arrLampadas){
            l.setConsumoTotal(0);
        }
    }

}
