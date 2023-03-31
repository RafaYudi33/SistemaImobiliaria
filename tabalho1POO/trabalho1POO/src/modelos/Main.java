/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import Arquivos.IOArquivos;
import interfaces.IUPrincipal;
import java.time.LocalDate;
import modelos.Cliente;
import controladores.Controlador;
/**
 *
 * @author Martines
 */
public class Main {
   
    public static void main(String[] args) {
        //carregar configurações
        IOArquivos arq = new IOArquivos();
        Imobiliaria imobiliaria = new Imobiliaria();
        imobiliaria.setConfiguracoes(arq.lerConfig());
        
        IUPrincipal principal = new IUPrincipal();
        principal.setVisible(true);
        principal.setTitle("Sistema Imobiliária");
        principal.toFront();
    }
}
