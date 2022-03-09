package Ficha3;

import java.util.Arrays;
import java.util.Objects;

public class Telemovel {
    private String marca, modelo;
    private int dispX, dispY;
    private long armMsgs, armTotal, armFotos, armApps, occupied;
    private int numFotos, numApps;
    private String apps[];

    private static int max_Apps = 100;

    public Telemovel(String marca, String modelo, int dispX, int dispY, int armMsgs, int armTotal, long armFotos, long armApps, long occupied, int numFotos, int numApps, String[] apps) {
        this.marca = marca;
        this.modelo = modelo;
        this.dispX = dispX;
        this.dispY = dispY;
        this.armMsgs = armMsgs;
        this.armTotal = armTotal;
        this.armFotos = armFotos;
        this.armApps = armApps;
        this.occupied = occupied;
        this.numFotos = numFotos;
        this.numApps = numApps;
        this.apps = new String [Telemovel.max_Apps];

        if (apps.length < Telemovel.max_Apps){
            System.arraycopy(apps, 0, this.apps, 0, apps.length);
        }
        else {
            System.arraycopy(apps, 0, this.apps, 0, Telemovel.max_Apps);
        }
    }

    public Telemovel(Telemovel t) {
        this.marca = t.marca;
        this.modelo = t.modelo;
        this.dispX = t.dispX;
        this.dispY = t.dispY;
        this.armMsgs = t.armMsgs;
        this.armTotal = t.armTotal;
        this.armFotos = t.armFotos;
        this.armApps = t.armApps;
        this.occupied = t.occupied;
        this.numFotos = t.numFotos;
        this.numApps = t.numApps;
        this.apps = new String [t.apps.length];

        if (apps.length < Telemovel.max_Apps){
            System.arraycopy(t.apps, 0, this.apps, 0, t.apps.length);
        }
        else {
            System.arraycopy(t.apps, 0, this.apps, 0, Telemovel.max_Apps);
        }
    }

    public Telemovel() {
        this.apps = new String [10];
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDispX(int dispX) {
        this.dispX = dispX;
    }

    public void setDispY(int dispY) {
        this.dispY = dispY;
    }

    public void setArmMsgs(long armMsgs) {
        this.armMsgs = armMsgs;
    }

    public void setArmTotal(long armTotal) {
        this.armTotal = armTotal;
    }

    public void setArmFotos(long armFotos) {
        this.armFotos = armFotos;
    }

    public void setArmApps(long armApps) {
        this.armApps = armApps;
    }

    public void setOccupied(long occupied) {
        this.occupied = occupied;
    }

    public void setNumFotos(int numFotos) {
        this.numFotos = numFotos;
    }

    public void setNumApps(int numApps) {
        this.numApps = numApps;
    }

    public void setApps(String[] apps) {
        System.arraycopy(apps, 0, this.apps, 0, Telemovel.max_Apps);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getDispX() {
        return dispX;
    }

    public int getDispY() {
        return dispY;
    }

    public long getArmMsgs() {
        return armMsgs;
    }

    public long getArmTotal() {
        return armTotal;
    }

    public long getArmFotos() {
        return armFotos;
    }

    public long getArmApps() {
        return armApps;
    }

    public long getOccupied() {
        return occupied;
    }

    public int getNumFotos() {
        return numFotos;
    }

    public int getNumApps() {
        return numApps;
    }

    public String[] getApps() {
        return apps.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Telemovel{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", dispX=").append(dispX);
        sb.append(", dispY=").append(dispY);
        sb.append(", armMsgs=").append(armMsgs);
        sb.append(", armTotal=").append(armTotal);
        sb.append(", armFotos=").append(armFotos);
        sb.append(", armApps=").append(armApps);
        sb.append(", occupied=").append(occupied);
        sb.append(", numFotos=").append(numFotos);
        sb.append(", numApps=").append(numApps);
        sb.append(", apps=").append(Arrays.toString(apps));
        sb.append('}');
        return sb.toString();
    }

    public Telemovel clone(){
        return new Telemovel(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telemovel telemovel = (Telemovel) o;
        return dispX == telemovel.dispX && dispY == telemovel.dispY && armMsgs == telemovel.armMsgs && armTotal == telemovel.armTotal && armFotos == telemovel.armFotos && armApps == telemovel.armApps && occupied == telemovel.occupied && numFotos == telemovel.numFotos && numApps == telemovel.numApps && Objects.equals(marca, telemovel.marca) && Objects.equals(modelo, telemovel.modelo) && Arrays.equals(apps, telemovel.apps);
    }

    /**
     * método que valida se um determinado conteúdo pode ser carregado para o telefone
     * @param numeroBytes
     * @return
     */
    public boolean existeEspaco(int numeroBytes){
        return true;
    }

    /**
     * método que carrega (isto é, instala) uma aplicação nova
     * @param nome nome da aplicação
     * @param tamanho tamanho (em bytes) da aplicação
     */
    public void instalaApp(String nome, int tamanho){

    }

    public void recebeMsg(String msg){

    }

    public double tamMedioApps(){
        return 0;
    }

    public String maiorMsg(){
        return "Ola";
    }

    public void removeApp(String nome, int tamanho){

    }



}
