package Ficha5.GestaoEncomendas;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {
    private Map<Integer, Encomenda> gestao;

    public GestaoEncomendas(){
        this.gestao = new HashMap<Integer, Encomenda>();
    }

    public GestaoEncomendas(Map<Integer, Encomenda> gestao){
        this.gestao = new HashMap<Integer, Encomenda>();
        this.gestao.putAll(gestao);
    }

    public Map<Integer, Encomenda> getGestao() {
        Map<Integer, Encomenda> result = new HashMap<Integer, Encomenda>();
        Set<Map.Entry<Integer, Encomenda>> entrySet = this.gestao.entrySet();

        for(Map.Entry a: entrySet){
            result.put((int) a.getKey(), ((Encomenda) a.getValue()).clone());
        }
        return result;
    }

    public void setGestao(Map<Integer, Encomenda> gestao) {
        Set<Map.Entry<Integer, Encomenda>> entrySet = gestao.entrySet();
        Iterator<Map.Entry<Integer, Encomenda>> it = entrySet.iterator();

        Map.Entry<Integer, Encomenda> entry;

        while (it.hasNext()){
            entry = it.next();
            this.gestao.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GestaoEncomendas{");
        sb.append("gestao=").append(gestao);
        sb.append('}');
        return sb.toString();
    }

    // i

    public Set<Integer> todosCodigosEnc(){
        Set<Integer> s = new HashSet<Integer>();

        for(Integer i: this.gestao.keySet()){
            s.add(i);
        }

        return s;
    }

    // ii

    public void addEncomenda(Encomenda enc){
        this.gestao.put(enc.getNEnc(), enc.clone());
    }

    // iii

    public Encomenda getEncomenda(Integer codEnc){
        return this.gestao.get(codEnc).clone();
    }

    // iv

    public void removeEncomenda(Integer codEnc){
        this.gestao.remove(codEnc);
    }

    // v

    public int encomendaComMaisProdutos(){
        return this.gestao.values().stream().max(Encomenda::compareTo).get().getNEnc();
    }

    // vi

    public Set<Integer> encomendasComProduto(String codProd){
        Set<Integer> setCods = new HashSet<Integer>();

        for(Integer cod: this.gestao.keySet()){
            Encomenda e = this.gestao.get(cod);
            if (e.existeProdutoEncomenda(codProd)){
                setCods.add(cod);
            }
        }

        return setCods;
    }

    // vii

    public Set<Integer> encomendasAposData(LocalDate d){
        return this.gestao.keySet().stream().filter(i -> this.gestao.get(i).getData().isAfter(d)).collect(Collectors.toSet());
    }

    // viii

    public Set<Encomenda> encomendasValorDecrescente(){
        return this.gestao.values().stream().collect(Collectors.toCollection(TreeSet::new));
    }

    // ix

    public Map<String,List<Integer>> encomendasDeProduto(){
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();

        Set<String> meusProdutos = new HashSet<String>();

        for(Integer cod: this.gestao.keySet()){
            Encomenda e = this.gestao.get(cod);
            for(LinhaEncomenda le : e.getLinhas()){
                meusProdutos.add(le.getReferencia());
            }
        }

        for(String ref: meusProdutos){
            map.put(ref, new ArrayList<Integer>());
            for(Encomenda e: this.gestao.values()){
                if (e.existeProdutoEncomenda(ref)){
                    List<Integer> l = map.get(ref);
                    l.add(e.getNEnc());
                    map.put(ref, l);
                }
            }
        }

        return map;
    }
}
