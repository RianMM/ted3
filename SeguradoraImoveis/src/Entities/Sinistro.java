package Entities;

import java.util.ArrayList;


public class Sinistro {
    private String data;
    private double porcentagem;
    private static ArrayList<Sinistro> listSinistre = new ArrayList<Sinistro>();



    public Sinistro(String data, double porcentagem) {
        this.data = data;
        this.porcentagem = porcentagem;
    }

    public static ArrayList<Sinistro> getListSinistre() {
        return listSinistre;
    }

    public static void setListSinistre(Sinistro listSinistre) {
        Sinistro.listSinistre.add(listSinistre);
    }



    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }


    public double getPorcentagem() {
        return porcentagem;
    }


    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public String toString() {
        return "Sinistro [data=" + data + ", porcentagem=" + porcentagem + "]";
    }

}