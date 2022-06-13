package Entities;

import Entities.Enum.TipoResidencia;
import Entities.Enum.TipoZona;

public class ContratoResidencial extends Contrato {
    private String endereco;
    private TipoZona tipoZona;
    private TipoResidencia tipoResidencia;

    public ContratoResidencial(Cliente cliente,double valor,Sinistro sinistro, String endereco, TipoZona tipoZona, TipoResidencia tipoResidencia) {
        super(cliente,valor,sinistro);
        this.endereco = endereco;
        this.tipoZona = tipoZona;
        this.tipoResidencia = tipoResidencia;
    }

    public double valorZona(){
        if(getTipoZona().equals(TipoZona.URBANA)){
            if(getTipoResidencia().equals(TipoResidencia.CASA)){
                return getValorImovel() * 0.005;
            }
            else{
                return getValorImovel() * 0.01;
            }
        }
        else if(getTipoZona().equals(TipoZona.SUBURBANA)){
            return getValorImovel() * 0.005;
        }else if(getTipoZona().equals(TipoZona.RURAL)){
            return getValorImovel() * 0.005;
        }
        return 0;
    }

    public double valorSeguro() {
        double valorSeguro = getValorImovel() * 0.02;
        valorSeguro += valorZona();
        return valorSeguro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoZona getTipoZona() {
        return tipoZona;
    }

    @Override
    public String toString() {
        return "ContratoResidencial{" +
                "Cliente = " +this.getCliente() +
                "Valor = " + this.getValorImovel()+
                " endereco='" + endereco + '\'' +
                ", tipoZona=" + tipoZona +
                ", tipoResidencia=" + tipoResidencia +
                '}';
    }

    public void setTipoZona(TipoZona tipoZona) {
        this.tipoZona = tipoZona;
    }

    public TipoResidencia getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(TipoResidencia tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }
}