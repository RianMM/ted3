package Entities;

import Entities.Enum.TipoRamo;

public class ContratoEmpresarial extends Contrato {
    private int numeroFuncionarios;
    private int visitasDiarias;
    private TipoRamo tipoRamo;

    public ContratoEmpresarial(Cliente cliente,double valor,Sinistro sinistro, int numeroFuncionarios, int visitasDiarias, TipoRamo tipoRamo) {
        super(cliente,valor, sinistro);
        this.numeroFuncionarios = numeroFuncionarios;
        this.visitasDiarias = visitasDiarias;
        this.tipoRamo = tipoRamo;
    }

    @Override
    public String toString() {
        return  "ContratoEmpresarial{" +
                "Cliente = " +this.getCliente() +
                "Valor = " + this.getValorImovel()+
                " numeroFuncionarios=" + numeroFuncionarios +
                ", visitasDiarias=" + visitasDiarias +
                ", tipoRamo=" + tipoRamo +
                '}';
    }

    public double valorRamo() {
        if(getTipoRamo().equals(TipoRamo.FÁBRICA)){
            return getValorImovel() * 0.01;
        }
        else if(getTipoRamo().equals(TipoRamo.LOJA)){
            return getValorImovel() * 0.005;
        }
        return 0;
    }

    public double valorSeguro() {
        double valorSeguro = getValorImovel() * 0.04;
        double quantFuncionarios = getNumeroFuncionarios();
        valorSeguro += (quantFuncionarios/10) * 0.002;
        double quantVisitas = getVisitasDiarias();
        valorSeguro += (quantVisitas/200) * 0.003;
        valorSeguro += valorRamo();
        return valorSeguro;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public int getVisitasDiarias() {
        return visitasDiarias;
    }

    public void setVisitasDiarias(int visitasDiarias) {
        this.visitasDiarias = visitasDiarias;
    }

    public TipoRamo getTipoRamo() {
        return tipoRamo;
    }

    public void setTipoRamo(TipoRamo tipoRamo) {
        this.tipoRamo = tipoRamo;
    }
}