package Entities;

import Entities.Enum.TipoPessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente {
    private long codigoPessoa;
    private String nome;
    private TipoPessoa tipoPessoa;
    private static ArrayList<Cliente> lstClientes = new ArrayList<Cliente>();
    private static HashMap<Long, Cliente> mapClienteDoc = new HashMap<Long, Cliente>();

    public static HashMap<Long, Cliente> getMapClienteDoc() {
        return mapClienteDoc;
    }

    public static ArrayList<Cliente> getLstClientes() {
        return lstClientes;
    }

    public static void setUtilClientes(Cliente cliente) {
        Cliente.mapClienteDoc.put(cliente.codigoPessoa,cliente);
        Cliente.lstClientes.add(cliente);
    }

    public Cliente(long codigoPessoa, String nome, TipoPessoa tipoPessoa) {
        this.codigoPessoa = codigoPessoa;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    public long getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigoPessoa=" + codigoPessoa +
                ", nome='" + nome + '\'' +
                ", tipoPessoa=" + tipoPessoa +
                '}';
    }

}