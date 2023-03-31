/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Martines
 */
public class Cartao extends Pagamento {
    private String nome; 
    private String bandeira; 
    private String numero; 

    public Cartao(String nome, String bandeira, String numero, String tipoPagamento) {
        super(tipoPagamento);
        this.nome = nome;
        this.bandeira = bandeira;
        this.numero = numero;
    }
    
    
    @Override
    public String toString(){
        return "\nCartao: "+
               "\n\tNome: " + nome + 
               "\n\tBandeira: " + bandeira +
               "\n\tNumero: " + numero;
    }
    
}
