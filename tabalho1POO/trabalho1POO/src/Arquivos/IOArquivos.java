/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Configuracao;
import modelos.Usuario;
import controladores.Controlador;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Aluguel;
import modelos.Cliente;
import modelos.Corretor;
import modelos.Imovel;
import modelos.Seguro;
import modelos.Venda;

/**
 *
 * @author Lucas
 */
public class IOArquivos {
    public Configuracao lerConfig(){
        try{
            File arquivoConfig = new File("config.arq");
            
            Configuracao configAtual;
            FileInputStream ios;
            if (arquivoConfig.exists() == false){
                configAtual = new Configuracao();
                this.escreverConfig(configAtual);
                return configAtual;
            }
            
            ios = new FileInputStream(arquivoConfig);
            ObjectInputStream ois = new ObjectInputStream(ios);
            
            configAtual = (Configuracao) ois.readObject();
            return configAtual;
            
        }catch( FileNotFoundException ex){
            return null;
        }catch(IOException | ClassNotFoundException ex){
            return null;
        }
    }
    
    public void escreverConfig(Configuracao novaConfig){
        try{
            File configFile = new File("config.arq");
            
            if(configFile.exists() == false)configFile.createNewFile();
            
            FileOutputStream fos = new FileOutputStream("config.arq");
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            
            ous.writeObject(novaConfig);
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo de configurações!");
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo de configurações!");
        }
    }
    
    public ArrayList<Cliente> lerClientes(){
        try{
            Controlador control = new Controlador();
            FileInputStream fis = new FileInputStream(control.getConfigClientes());
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            int contClientes = ois.readInt();
            ArrayList<Cliente> clientes = new ArrayList<>();
            
            for(int i = 0; i < contClientes;i++){
                clientes.add((Cliente) ois.readObject());
            }
            
            return clientes;
            
        }catch(IOException ex){
            return null;
        }catch(ClassNotFoundException ex){
            return null;
        }
    }
    
    public ArrayList<Corretor> lerCorretores(){
        try{
            Controlador control = new Controlador();
            FileInputStream fis = new FileInputStream(control.getConfigCorretores());
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            int contCorretores = ois.readInt();
            ArrayList<Corretor> corretores = new ArrayList<>();
            
            for(int i = 0; i < contCorretores;i++){
                corretores.add((Corretor) ois.readObject());
            }
            
            return corretores;
            
        }catch(IOException ex){
            return null;
        }catch(ClassNotFoundException ex){
            return null;
        }
    }
    
    public void escreverCliente(Cliente cliente){
        
        try {
            Controlador control = new Controlador();
            File arquivoClientes = new File(control.getConfigClientes());
            ArrayList<Cliente> clientes;
            clientes = lerClientes();
            
            int contClientes;
            
            if(arquivoClientes.exists() == false) arquivoClientes.createNewFile();
             
            FileOutputStream fos = new FileOutputStream(arquivoClientes);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            
            
            
            if(clientes != null){
                clientes.add(cliente);
                contClientes = clientes.size();
                ous.writeInt(contClientes);
                for(int i = 0;i<contClientes;i++){
                    ous.writeObject(clientes.get(i));
                }
            }else{
                ous.writeInt(1);
                ous.writeObject(cliente);
            }
            ous.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado Com Sucesso!!");
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo de Clientes");
        } catch (IOException ex) {
            Logger.getLogger(IOArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void escreverCorretor(Corretor corretor){
        
        try {
            Controlador control = new Controlador();
            File arquivoCorretores = new File(control.getConfigCorretores());
            ArrayList<Corretor> corretores;
            corretores = lerCorretores();
            
            int contCorretores;
            
            if(arquivoCorretores.exists() == false) arquivoCorretores.createNewFile();
             
            FileOutputStream fos = new FileOutputStream(arquivoCorretores);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            
            
            
            if(corretores != null){
                corretores.add(corretor);
                contCorretores = corretores.size();
                ous.writeInt(contCorretores);
                for(int i = 0;i<contCorretores;i++){
                    ous.writeObject(corretores.get(i));
                }
            }else{
                ous.writeInt(1);
                ous.writeObject(corretor);
            }
            ous.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Corretor Cadastrado Com Sucesso!!");
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo de Clientes");
        } catch (IOException ex) {
            Logger.getLogger(IOArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Imovel> lerImoveis(){
        try{
            Controlador control = new Controlador();//controlador para pegar as configs da classe imovel
            FileInputStream fis = new FileInputStream(control.getConfigImoveis()); //faz a conexao com o arquivo que possui os dados dos imoveis
            ObjectInputStream ois = new ObjectInputStream(fis);//objeto que le as informacoes passadas por um inputStream(fis)
            
            int contImoveis = ois.readInt();
            ArrayList<Imovel> imoveis = new ArrayList<>();
            
            for (int i = 0; i < contImoveis ; i++) {    
                imoveis.add((Imovel) ois.readObject());
            }
            return imoveis;
            
        }catch(IOException ex){
            return null;
        }catch(ClassNotFoundException ex){
            return null;
        }
    }
    
    public void escreverImovel(Imovel imovel){
        try{
            Controlador control = new Controlador();
            File arquivoImoveis = new File(control.getConfigImoveis());
            ArrayList<Imovel> imoveis =  lerImoveis();
            
            int contImoveis;
            
            if(arquivoImoveis.exists() == false) arquivoImoveis.createNewFile();
            
            FileOutputStream fos = new FileOutputStream(arquivoImoveis);//conecta o arquivo em que as informacoes serao gravadas
            ObjectOutputStream ous = new ObjectOutputStream(fos);//manipula o objeto que sera inserido dentro do arquivo de dados, no seu construtor informamos o arquivo do OutputStream(fos)
            
            
            if(imoveis != null){
                imoveis.add(imovel);//add o novo imovel ao ArrayList
                contImoveis = imoveis.size();//Atualiza o valor do contador de imoveis com o tamanho do vetor de imoveis
                ous.writeInt(contImoveis);// registra a quantidade de imoveis no arquivo
                for(int i = 0; i < contImoveis; i++){
                    ous.writeObject(imoveis.get(i));//faz a escrita do novo imovel no arquivo
                }
            }else{
                ous.writeInt(1);
                ous.writeObject(imovel);
            }
            
            ous.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "imóvel Cadastrado com sucesso!");
            
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o arquivo de Imoveis");
        }catch(IOException ex){
            Logger.getLogger(IOArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Venda> lerVendas(){
        try{
            Controlador control = new Controlador();
            FileInputStream fis =  new FileInputStream(control.getConfigVendas());
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            int contVendas = ois.readInt();
            ArrayList<Venda> vendas = new ArrayList<>();
            
            for(int i = 0; i < contVendas; i++){
                vendas.add((Venda) ois.readObject());
            }
            return vendas;
            
        }catch(IOException ex){
            return null;
        }catch(ClassNotFoundException ex){
            return null;
        }
    }
    
    public void escreverVenda(Venda venda){
        try{
            Controlador control = new Controlador();
            File arquivoVendas = new File(control.getConfigVendas());
            ArrayList<Venda> vendas = lerVendas();

            int contVendas;

            if(arquivoVendas.exists() == false)arquivoVendas.createNewFile();
            
            FileOutputStream fos = new FileOutputStream(arquivoVendas);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            
            if(vendas != null){
                vendas.add(venda);
                contVendas = vendas.size();
                ous.writeInt(contVendas);
                for(int i = 0; i < contVendas; i++){
                    ous.writeObject(vendas.get(i));
                }
            }else{
                ous.writeInt(1);
                ous.writeObject(venda);
            }
            
            ous.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "A venda foi cadastrada com sucesso!");
            
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo de vendas.");
        }catch(IOException ex){
            Logger.getLogger(IOArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Aluguel> lerAlugueis(){
            try {
                Controlador control = new Controlador();
                FileInputStream fis = new FileInputStream(control.getConfigAlugueis());
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                int contAlugueis = ois.readInt();
                ArrayList<Aluguel> alugueis = new ArrayList<>();
                
                for(int i = 0; i < contAlugueis; i++){
                    alugueis.add((Aluguel) ois.readObject());
                }
                return alugueis;
                
            }catch(IOException ex) {
                return null;
            }catch(ClassNotFoundException ex ){
                return null;
            }
        }
    
    public void escreverAlugueis(Aluguel aluguel){
        try{
            Controlador control = new Controlador();
            File arquivoAlugueis = new File(control.getConfigAlugueis());
            ArrayList<Aluguel> alugueis = lerAlugueis();
            
            int contAlugueis;
            if(arquivoAlugueis.exists() == false)arquivoAlugueis.createNewFile();
            
            FileOutputStream fos = new FileOutputStream(arquivoAlugueis);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            
            if( alugueis != null){
                alugueis.add(aluguel);
                contAlugueis = alugueis.size();
                ous.writeInt(contAlugueis);
                for(int i = 0; i < contAlugueis; i++){
                    ous.writeObject(alugueis.get(i));
                }
            }else{
                ous.writeInt(1);
                ous.writeObject(aluguel);
            }
            ous.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Aluguel cadastrado com sucesso!");
            
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo de alugueis!");
        }catch(IOException ex){
            Logger.getLogger(IOArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Seguro> lerSeguros(){
        try{
            Controlador control = new Controlador();
            FileInputStream fis = new FileInputStream(control.getConfigSeguros());
            ObjectInputStream ois = new ObjectInputStream(fis);
            
           int contSeguros = ois.readInt();
           ArrayList<Seguro> seguros = new ArrayList<>();
           
           for(int i = 0; i < contSeguros; i++){
               seguros.add((Seguro) ois.readObject());
           }
           return seguros;
            
        }catch(IOException ex){
            return null;
        }catch(ClassNotFoundException ex){
            return null;
        }
    }
    
    public void escreverSeguros(Seguro seguro){
        try{
            Controlador control = new Controlador();
            File arquivoSeguros = new File(control.getConfigSeguros());
            ArrayList<Seguro> seguros = lerSeguros();
            int contSeguros;
            
            if(arquivoSeguros.exists() == false)arquivoSeguros.createNewFile();
            
            FileOutputStream fos = new FileOutputStream(arquivoSeguros);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            
            if( seguros != null){
                seguros.add(seguro);
                contSeguros = seguros.size();
                ous.writeInt(contSeguros);
                for(int i = 0; i < contSeguros; i++){
                    ous.writeObject(seguros.get(i));
                }
            }else{
                ous.writeInt(1);
                ous.writeObject(seguro);
            }
            ous.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Seguro Cadastrado com sucesso!");
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Problema ao Abrir o arquivo de seguros!!");
        }catch(IOException ex){
            Logger.getLogger(IOArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
