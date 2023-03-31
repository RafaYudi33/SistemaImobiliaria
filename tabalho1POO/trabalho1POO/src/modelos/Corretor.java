/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Martines
 */
public class Corretor extends Usuario{
    protected String creci; 
    protected float salario; 
    protected String pis; 
    protected LocalDate dataAdmissao; 

    public Corretor(String creci, float salario, String pis, LocalDate dataAdmissao, int codigoUsuario, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String telefone, String email) {
        super(codigoUsuario, nome, cpf, rg, dataNascimento, endereco, cep, telefone, email);
        this.creci = creci;
        this.salario = salario;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public String toString() {
        return "\nCorretor: " + 
               "\n\tCodigo: " + codigoUsuario + 
               "\n\tNome: " + nome +
               "\n\tCPF: " + cpf +
               "\n\tRG: " + rg +
               "\n\tData de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
               "\n\tEndereco: " + endereco + 
               "\n\tCEP" + cep +
               "\n\tTelefone: " + telefone +
               "\n\tEmail: " + email +
               "\n\tCreci: " + creci + 
               "\n\tSalario: R$ " + salario + 
               "\n\tPIS: " + pis + 
               "\n\tData de Admissao: " + dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    
    
}
