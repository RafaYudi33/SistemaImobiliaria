/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lucas
 */
public class CasaResidencial extends Imovel{

    public CasaResidencial(int codigoImovel, String endereco, LocalDate dataConstrucao, float areaTotal, float areaConstruida, int qtdDormitorios, int qtdBanheiros, int qtdVagasGaragem, float valorIptu, float valorVenda, float valorAluguel, boolean disponivelAluguel, boolean disponivelVenda) {
        super(codigoImovel, endereco, dataConstrucao, areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros, qtdVagasGaragem, valorIptu, valorVenda, valorAluguel, disponivelAluguel, disponivelVenda);
    }

    @Override
    public float getValorAluguel(){
        return this.valorAluguel;
    }

    @Override
    public String toString() {
        return "\nCasa Residencial: " + 
               "\n\tCodigo: " + codigoImovel +
               "\n\tEndereco: " + endereco + 
               "\n\tData da Construcao: " + dataConstrucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
               "\n\tArea Total: " + areaTotal + 
               "\n\tArea Construída: " + areaConstruida +
               "\n\tQuantidade de Dormitorios: " + qtdDormitorios + 
               "\n\tQuantidade de Banheiros: " + qtdBanheiros + 
               "\n\tVagas de garagem: " + qtdVagasGaragem + 
               "\n\tValor do IPTU: R$ " + valorIptu +
               "\n\tValor de Venda: R$ " + valorVenda + 
               "\n\tValor do Aluguel: R$ " + valorAluguel;
    }
    
    
}
