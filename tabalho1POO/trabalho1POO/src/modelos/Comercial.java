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
public class Comercial extends Imovel{
    protected float taxaImpostoFederal;

    public Comercial(float taxaImpostoFederal, int codigoImovel, String endereco, LocalDate dataConstrucao, float areaTotal, float areaConstruida, int qtdDormitorios, int qtdBanheiros, int qtdVagasGaragem, float valorIptu, float valorVenda, float valorAluguel, boolean disponivelAluguel, boolean disponivelVenda) {
        super(codigoImovel, endereco, dataConstrucao, areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros, qtdVagasGaragem, valorIptu, valorVenda, valorAluguel, disponivelAluguel, disponivelVenda);
        this.taxaImpostoFederal = taxaImpostoFederal;
    }


    public float getTaxaImpostoFederal() {
        return taxaImpostoFederal;
    }

    public void setTaxaImpostoFederal(float taxaImpostoFederal) {
        this.taxaImpostoFederal = taxaImpostoFederal;
    }

    @Override
    public float getValorAluguel(){
        return ((this.taxaImpostoFederal/100) * this.valorAluguel) + this.valorAluguel;
    }
    
    
@Override
    public String toString() {
        return "\nComercial: " + 
               "\n\tCodigo: " + codigoImovel +
               "\n\tEndereco: " + endereco + 
               "\n\tData da Construcao: " + dataConstrucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
               "\n\tArea Total: " + areaTotal + 
               "\n\tArea Construida: " + areaConstruida +
               "\n\tQuantidade de Dormitorios: " + qtdDormitorios + 
               "\n\tQuantidade de Banheiros: " + qtdBanheiros + 
               "\n\tVagas de garagem: " + qtdVagasGaragem + 
               "\n\tTaxa do Imposto Federal: " + taxaImpostoFederal +
               "\n\tValor do IPTU: R$ " + valorIptu +
               "\n\tValor de Venda: R$ " + valorVenda + 
               "\n\tValor do Aluguel: R$ " + valorAluguel;
    }
    
    
    
    
}
