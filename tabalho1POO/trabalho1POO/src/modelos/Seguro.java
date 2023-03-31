/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class Seguro implements Serializable{
    private int codigoSeguro;
    private String nomeSeguradora;
    private String tipo;
    private String descricao;
    private float valor;

    public Seguro(int codigoSeguro, String nomeSeguradora, String tipo, String descricao, float valor) {
        this.codigoSeguro = codigoSeguro;
        this.nomeSeguradora = nomeSeguradora;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigoSeguro() {
        return codigoSeguro;
    }

    public void setCodigoSeguro(int codigoSeguro) {
        this.codigoSeguro = codigoSeguro;
    }

    public String getNomeSeguradora() {
        return nomeSeguradora;
    }

    public void setNomeSeguradora(String nomeSeguradora) {
        this.nomeSeguradora = nomeSeguradora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\nSeguro: " +
               "\n\tCodigo: " + codigoSeguro +
               "\n\tSeguradora: " + nomeSeguradora + 
               "\n\tTipo: " + tipo + 
               "\n\tDescricao: " + descricao + 
               "\n\tValor: R$" + valor ;
    }
    
    
    
}
