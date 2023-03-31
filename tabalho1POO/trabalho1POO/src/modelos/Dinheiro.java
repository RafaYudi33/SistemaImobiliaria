/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Martines
 */
public class Dinheiro extends Pagamento{

    public Dinheiro(String tipoPagamento) {
        super(tipoPagamento);
    }
    
    @Override
    public String toString() {
        return "Dinheiro";
    }
    
}
