
package modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Martines
 */
public class Cliente extends Usuario {
    protected LocalDate dataCadastro; 

    public Cliente(LocalDate dataCadastro, int codigoUsuario, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String telefone, String email) {
        super(codigoUsuario, nome, cpf, rg, dataNascimento, endereco, cep, telefone, email);
        this.dataCadastro = dataCadastro;
    }


    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {  
        return "\nCliente: " + 
               "\n\tCodigo: " + codigoUsuario + 
               "\n\tNome: " + nome + 
               "\n\tCPF: " + cpf + 
               "\n\tRG: " + rg + 
               "\n\tData de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
               "\n\tEndereco: " + endereco +
               "\n\tCEP: " + cep +
               "\n\tTelefone: " + telefone + 
               "\n\tEmail: " + email +
               "\n\tData do Cadastro: " + dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
   
    
}