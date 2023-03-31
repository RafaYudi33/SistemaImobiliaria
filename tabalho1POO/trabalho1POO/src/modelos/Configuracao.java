/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Lucas
 */
public class Configuracao {
    private String arquivoAlugueis;//ja foi
    private String arquivoVendas;//ja foi
    private String arquivoImoveis;//ja foi
    private String arquivoClientes;//ja foi
    private String arquivoCorretores;//ja foi
    private String arquivoSeguros;
    
    public Configuracao() {
        this.arquivoAlugueis = "alugueis.arq";
        this.arquivoVendas = "vendas.arq";
        this.arquivoImoveis = "imoveis.arq";
        this.arquivoClientes = "clientes.arq";
        this.arquivoCorretores = "corretores.arq";
        this.arquivoSeguros = "seguros.arq";
    }

    public String getArquivoAlugueis() {
        return arquivoAlugueis;
    }

    public void setArquivoAlugueis(String arquivoAlugueis) {
        this.arquivoAlugueis = arquivoAlugueis;
    }

    public String getArquivoVendas() {
        return arquivoVendas;
    }

    public void setArquivoVendas(String arquivoVendas) {
        this.arquivoVendas = arquivoVendas;
    }

    public String getArquivoImoveis() {
        return arquivoImoveis;
    }

    public void setArquivoImoveis(String arquivoImoveis) {
        this.arquivoImoveis = arquivoImoveis;
    }

    public String getArquivoClientes() {
        return arquivoClientes;
    }

    public void setArquivoClientes(String arquivoClientes) {
        this.arquivoClientes = arquivoClientes;
    }

    public String getArquivoCorretores() {
        return arquivoCorretores;
    }

    public void setArquivoCorretores(String arquivoCorretores) {
        this.arquivoCorretores = arquivoCorretores;
    }

    public String getArquivoSeguros() {
        return arquivoSeguros;
    }

    public void setArquivoSeguros(String arquivoSeguros) {
        this.arquivoSeguros = arquivoSeguros;
    }
    
    
    
}

