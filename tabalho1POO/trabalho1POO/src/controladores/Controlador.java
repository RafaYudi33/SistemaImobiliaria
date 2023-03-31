/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Arquivos.IOArquivos;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Aluguel;
import modelos.ApartamentoResidencial;
import modelos.CasaResidencial;
import modelos.Cliente;
import modelos.Comercial;
import modelos.Configuracao;
import modelos.Corretor;
import modelos.Imobiliaria;
import modelos.Imovel;
import modelos.Seguro;
import modelos.Venda;

/**
 *
 * @author Lucas
 */
public class Controlador {
    
    public static Imobiliaria imobiliaria = new Imobiliaria();
    
    /* set e get das configuracoes*/
    public Configuracao getConfiguracoes(){
        return imobiliaria.getConfiguracoes();
    }
    
    public void setConfiguracoes(Configuracao config){
        imobiliaria.setConfiguracoes(config);
        IOArquivos arq = new IOArquivos();
        arq.escreverConfig(config);
        JOptionPane.showMessageDialog(null, "configurações slavas com sucesso!");
    }
    
    
    /* funções para recuperar arquivos de configurações */
    
    public String getConfigClientes(){
        return imobiliaria.getConfiguracoes().getArquivoClientes();
    }
    
    public String getConfigCorretores(){
        return imobiliaria.getConfiguracoes().getArquivoCorretores();
    }
    
    public String getConfigImoveis(){
        return imobiliaria.getConfiguracoes().getArquivoImoveis();
    }
    
    public String getConfigVendas(){
        return imobiliaria.getConfiguracoes().getArquivoVendas();
    }
    
    public String getConfigAlugueis(){
        return imobiliaria.getConfiguracoes().getArquivoAlugueis();
    }
    
    public String getConfigSeguros(){
        return imobiliaria.getConfiguracoes().getArquivoSeguros();
    }
    
    //funções para add registros aos arquivos
    
    public void addCliente(Cliente novoCliente){
        IOArquivos arq = new IOArquivos();
        arq.escreverCliente(novoCliente);
    }
    
    public void addCorretor(Corretor novoCorretor){
        IOArquivos arq = new IOArquivos();
        arq.escreverCorretor(novoCorretor);
    }
    
    public void addAluguel(Aluguel novoAluguel){
        IOArquivos arq = new IOArquivos();
        arq.escreverAlugueis(novoAluguel);
    }
    
    public void addImovel(Imovel novoImovel){
        IOArquivos arq = new IOArquivos();
        arq.escreverImovel(novoImovel);
    }
    
    public void addVenda(Venda novaVenda){
        IOArquivos arq = new IOArquivos();
        arq.escreverVenda(novaVenda);
    }
    
    public void addSeguro(Seguro novoSeguro){
        IOArquivos arq = new IOArquivos();
        arq.escreverSeguros(novoSeguro);
    }
    
    //funções para listagem dos imoveis
    //1. Listar todos os Imóveis cadastrados, seja Casa Residencial, Apartamento Residencial ou Comercial.
    public ArrayList<Imovel> listaTodosOsImoveis(){
        IOArquivos arq = new IOArquivos();
        return arq.lerImoveis();
    }
    
    //2. Listar todos os Imóveis de categoria Casa Residencial.
    public ArrayList<CasaResidencial> listaTodasAsCasasResidenciais(){
        IOArquivos arq = new IOArquivos();
        ArrayList<CasaResidencial> todasCasasResidenciais = new ArrayList();
        ArrayList<Imovel> todosOsImoveis= arq.lerImoveis();
        if(todosOsImoveis != null){
            for(int i =0; i < todosOsImoveis.size(); i++){
                if(todosOsImoveis.get(i) instanceof CasaResidencial){
                    todasCasasResidenciais.add((CasaResidencial)todosOsImoveis.get(i));
                }
            }
            return todasCasasResidenciais;
        }else{
            return null;
        }
    }
    
    //3. Listar todos os Imóveis de categoria Apartamento Residencial.
    public ArrayList<ApartamentoResidencial> listaTodosOsApartamentosResidenciais(){
        IOArquivos arq = new IOArquivos();
        ArrayList<ApartamentoResidencial> todosApartamentosResidenciais = new ArrayList();
        ArrayList<Imovel> todosOsImoveis= arq.lerImoveis();
        if(todosOsImoveis != null){
            for(int i =0; i < todosOsImoveis.size(); i++){
                if(todosOsImoveis.get(i) instanceof ApartamentoResidencial){
                    todosApartamentosResidenciais.add((ApartamentoResidencial)todosOsImoveis.get(i));
                }
            }
            return todosApartamentosResidenciais;
        }else{
            return null;
        }
    }
    
    //4. Listar todos os Imóveis de categoria Comercial.
    public ArrayList<Comercial> listaTodosOsComerciais(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Comercial> todosComerciais = new ArrayList();
        ArrayList<Imovel> todosOsImoveis= arq.lerImoveis();
        if(todosOsImoveis != null){
            for(int i =0; i < todosOsImoveis.size(); i++){
                if(todosOsImoveis.get(i) instanceof Comercial){
                    todosComerciais.add((Comercial)todosOsImoveis.get(i));
                }
            }
            return todosComerciais;
        }else{
            return null;
        }
    }
    
    //5. Listar todos os Imóveis disponíveis para locação (aluguel).
    public ArrayList<Imovel> listaImoveisDisponiveisLocacao(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Imovel> todosImoveis = arq.lerImoveis();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        
        //array para armazenar os index que serão excluidos.
        int[] index = new int[todosAlugueis.size()];
        
        //pega os index para excluir os imoveis alugados.
        for(int i = 0; i < todosAlugueis.size(); i++){
            for(int j = 0; j < todosImoveis.size(); j++){
                if(todosAlugueis.get(i).getImovel().equals(todosImoveis.get(j))){
                    index[i] = todosImoveis.indexOf(j);
                }
                
            }
        }
        //exclui os imoveis alugados.
        for(int i = 0; i < index.length; i++){
            todosImoveis.remove(index[i]);
        }
        
        //retorna os imoveis disponiveis.
        return todosImoveis;
    }
    
    //6. Listar todos os Imóveis não disponíveis para locação, ou seja, alugados ou vendidos.
    public ArrayList<Imovel> listaImoveisIndisponiveis(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Imovel> todosImoveis = arq.lerImoveis();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<Venda> todasVendas = arq.lerVendas();
        ArrayList<Imovel> imoveisIndisponiveis = new ArrayList();
        
        //arrays para armazenar os index dos objetos que serao retornados.
        int[] indexAluguel = new int[todosAlugueis.size()];
        int[] indexVenda = new int[todasVendas.size()];
        
        //pega os index para excluir os imoveis alugados.
        for(int i = 0; i < todosAlugueis.size(); i++){
            for(int j = 0; j < todosImoveis.size(); j++){
                if(todosAlugueis.get(i).getImovel().equals(todosImoveis.get(j))){
                    indexAluguel[i] = todosImoveis.indexOf(j);
                }
                
            }
        }
        for(int i = 0; i < todasVendas.size(); i++){
            for(int j = 0; j < todosImoveis.size(); j++){
                if(todasVendas.get(i).getImovel().equals(todosImoveis.get(j))){
                    indexVenda[i] = todosImoveis.indexOf(j);
                }
                
            }
        }

        //exclui os imoveis alugados.
        for(int i = 0; i < indexAluguel.length; i++){
            imoveisIndisponiveis.add(todosImoveis.get(indexAluguel[i]));
        }
        for(int i = 0; i < indexVenda.length; i++){
            imoveisIndisponiveis.add(todosImoveis.get(indexVenda[i]));
        }
        
        //retorna os imoveis disponiveis.
        return imoveisIndisponiveis;
    }
    
    //7. Listar todos os Imóveis disponíveis para vendas.
    public ArrayList<Imovel> listaImoveisDisponiveisCompra(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Imovel> todosImoveis = arq.lerImoveis();
        ArrayList<Venda> todasVendas = arq.lerVendas();
        
        //array para armazenar os index que serão excluidos.
        int[] index = new int[todasVendas.size()];
        
        //pega os index para excluir os imoveis vendidos.
        for(int i = 0; i < todasVendas.size(); i++){
            for(int j = 0; j < todosImoveis.size(); j++){
                if(todasVendas.get(i).getImovel().equals(todosImoveis.get(j))){
                    index[i] = todosImoveis.indexOf(j);
                }
                
            }
        }
        //exclui os imoveis vendidos.
        for(int i = 0; i < index.length; i++){
            todosImoveis.remove(index[i]);
        }
        
        //retorna os imoveis disponiveis.
        return todosImoveis;
    }
    
    //8. Listar todos os Imóveis com atraso no pagamento do aluguel.
    public ArrayList<Imovel> listaImoveisAlugueisAtrasados(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosOsAlugueis = arq.lerAlugueis();
        ArrayList<Imovel> imoveisAtrasados = new ArrayList();
        
        if(todosOsAlugueis == null){
            return null;
        }else{
            for(int i = 0; i < todosOsAlugueis.size(); i++){
                if(todosOsAlugueis.get(i).verificarAtraso()){
                    imoveisAtrasados.add(todosOsAlugueis.get(i).getImovel());
                }
            }
            return imoveisAtrasados;
        }
    }
    
    //9. Listar todos os Imóveis já alugados por um Cliente em específico.
    public ArrayList<Imovel> listaImoveisAlugadosClienteEspecifico(int codigoCliente){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<Imovel> imoveisDoCliente = new ArrayList();
        if(todosAlugueis == null){
            return null;
        }else{
            for(int i = 0; i < todosAlugueis.size() ; i++){
                if(todosAlugueis.get(i).getCliente().getCodigoUsuario() == codigoCliente){
                    imoveisDoCliente.add(todosAlugueis.get(i).getImovel());
                }
            }
            return imoveisDoCliente;
        }
    }
    
    //10. Listar todos os Imóveis já comprados por um Cliente em específico.
    public ArrayList<Imovel> listaImoveisCompradosClienteEspecifico(int codigoCliente){
        IOArquivos arq = new IOArquivos();
        ArrayList<Venda> todasVendas = arq.lerVendas();
        ArrayList<Imovel> imoveisDoCliente = new ArrayList();
        if(todasVendas == null){
            return null;
        }else{
            for(int i = 0; i < todasVendas.size() ; i++){
                if(todasVendas.get(i).getCliente().getCodigoUsuario() == codigoCliente){
                    imoveisDoCliente.add(todasVendas.get(i).getImovel());
                }
            }
            return imoveisDoCliente;
        }
    }
    
    //11. Listar todos os Corretores cadastrados.
    public ArrayList<Corretor> listarTodosOsCorretores(){
        IOArquivos arq = new IOArquivos();
        return arq.lerCorretores();
    }
    
    //12.  Listar o Corretores ganhadores do funcionário do mês, ou seja, os corretores que mais alugueis ou vendas realizaram em cada um dos meses.
    public Corretor corretorFuncionarioDoMes(String mes){
        IOArquivos arq = new IOArquivos();
        ArrayList<Venda> vendasMes = this.listaTodasVendasMes(Integer.parseInt(mes));
        ArrayList<Aluguel> aluguelMes = this.listaTodosAluguelMes(Integer.parseInt(mes));
        ArrayList<Corretor> todosCorretores = arq.lerCorretores();
        int[] codCor = new int[todosCorretores.size()];
        for(int i = 0; i < todosCorretores.size(); i++){
            codCor[i] = todosCorretores.get(i).getCodigoUsuario();
        }
        for(int i = 0; i < codCor.length; i++){
            
        }
        
        
        
        return null;
    }
    
    //13.  Listar todos os Clientes cadastrados.
    public ArrayList<Cliente> getTodosClientes(){
        IOArquivos arq = new IOArquivos();
        return arq.lerClientes();    
    }
    
    //14. Listar o histórico de compras, imóveis comprados por um Cliente em específico.
    public ArrayList<Venda> listaHistoricoComprasClienteEspecifico(int codCliente){
        IOArquivos arq = new IOArquivos();
        ArrayList<Venda> todasVendas = arq.lerVendas();
        ArrayList<Venda> historico = new ArrayList();
        for(int i = 0; i < todasVendas.size(); i++){
            if(todasVendas.get(i).getCliente().getCodigoUsuario() == codCliente){
                historico.add(todasVendas.get(i));
                
            }
        }
        return historico;
    }
    
    //Função nova
    public ArrayList<Aluguel> listaHistoricoCAlugueisClienteEspecifico(int codCliente){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<Aluguel> historico = new ArrayList();
        for(int i = 0; i < todosAlugueis.size(); i++){
            if(todosAlugueis.get(i).getCliente().getCodigoUsuario() == codCliente){
                historico.add(todosAlugueis.get(i));
                
            }
        }
        return historico;
    }
    
    
    
    //15. Listar Clientes com alugueis em atraso.
    public ArrayList<Cliente> listaClientesComAlugueisAtrasados(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<Cliente> clientesAtrasados = new ArrayList();
        
        for(int i = 0; i < todosAlugueis.size(); i++){
            if(todosAlugueis.get(i).verificarAtraso()){
                clientesAtrasados.add(todosAlugueis.get(i).getCliente());
            }
        }
        return clientesAtrasados;
    }
    
    //16. Listar todos os Alugueis (Locações) realizados finalizados ou não.
    public ArrayList<Aluguel> listaTodosOsAlugueis(){
        IOArquivos arq = new IOArquivos();
        return arq.lerAlugueis();
    }
    
    //17. Listar todos os Alugueis finalizados, ou seja, que já concluíram contrato e foram devolvidos.
    public ArrayList<Aluguel> listaAlugueisFinalizados(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<Aluguel> alugueisFinalizados = new ArrayList();
        LocalDate dataAtual = LocalDate.now();
        
        for(int i = 0; i < todosAlugueis.size(); i++){
            if( todosAlugueis.get(i).getDataDevolucao().isBefore(dataAtual)){
                alugueisFinalizados.add(todosAlugueis.get(i));
            }
        }
        return alugueisFinalizados;
    }
    

    //18. Listar todos os Alugueis não finalizados, ou seja, ainda dentro do prazo de locação.
    public ArrayList<Aluguel> listaAlugueisNaoFinalizados(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<Aluguel> alugueisNaoFinalizados = new ArrayList();
        LocalDate dataAtual = LocalDate.now();
        
        for(int i = 0; i < todosAlugueis.size(); i++){
            if(( todosAlugueis.get(i).getDataDevolucao().isAfter(dataAtual))){
                alugueisNaoFinalizados.add(todosAlugueis.get(i));
            }
        }
        return alugueisNaoFinalizados;
    }
    
    //19. Listar todos as Casas Residenciais alugadas com contrato ainda vigente.
    
    public ArrayList<CasaResidencial> listaCasasResidenciaisContratoVigente(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<CasaResidencial> casasResidenciaisContratoVigente = new ArrayList();
        LocalDate dataAtual = LocalDate.now();
        
        for(int i = 0; i < todosAlugueis.size(); i++){
            if(todosAlugueis.get(i).getImovel() instanceof CasaResidencial){
                if (todosAlugueis.get(i).getDataDevolucao().isAfter(dataAtual)){
                    casasResidenciaisContratoVigente.add((CasaResidencial)todosAlugueis.get(i).getImovel());
                }
            }
        }
        return casasResidenciaisContratoVigente;
    }
    
    //20. Listar todos os Apartamentos Residenciais alugadas com contrato ainda vigente.
    public ArrayList<ApartamentoResidencial> listaApartamentosResidenciaisContratoVigente(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<ApartamentoResidencial> ApartamentosResidenciaisContratoVigente = new ArrayList();
        LocalDate dataAtual = LocalDate.now();
        
        for(int i = 0; i < todosAlugueis.size(); i++){
            if(todosAlugueis.get(i).getImovel() instanceof ApartamentoResidencial){
                if (todosAlugueis.get(i).getDataDevolucao().isAfter(dataAtual)){
                    ApartamentosResidenciaisContratoVigente.add((ApartamentoResidencial)todosAlugueis.get(i).getImovel());
                }
            }
        }
        return ApartamentosResidenciaisContratoVigente;
    }

    //21. Listar todos os Estabelecimentos Comerciais alugadas com contrato ainda vigente.
    public ArrayList<Comercial> listaComerciaisContratoVigente(){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        ArrayList<Comercial> ComercialContratoVigente = new ArrayList();
        LocalDate dataAtual = LocalDate.now();
        
        for(int i = 0; i < todosAlugueis.size(); i++){
            if(todosAlugueis.get(i).getImovel() instanceof Comercial){
                if (todosAlugueis.get(i).getDataDevolucao().isAfter(dataAtual)){
                    ComercialContratoVigente.add((Comercial)todosAlugueis.get(i).getImovel());
                }
            }
        }
        return ComercialContratoVigente;
    }
    
    //22. Listar todas as Vendas realizadas.
    public ArrayList<Venda> listaTodasVendas(){
        IOArquivos arq = new IOArquivos();
        return arq.lerVendas();
    }
    
    //Funcao para somar todo os valores das vendas
    public float calculaValorTotalVenda(ArrayList<Venda> Vendas){
        float soma = 0;
        for(int i = 0; i < Vendas.size(); i++){
            soma += Vendas.get(i).getValorTotalVenda();
        }
        return soma;
    }
    
    public float calculaValorTotalAlugueis(ArrayList<Aluguel> alugueis){
        float soma = 0;
        for(int i = 0; i < alugueis.size(); i++){
            soma += alugueis.get(i).getValorTotalAluguel();
        }
        return soma;
    }
    
    //23. Listar Vendas realizadas em um mês em específico
    public ArrayList<Venda> listaTodasVendasMes(int mes){
        mes++;
        IOArquivos arq = new IOArquivos();
        ArrayList<Venda> todasVendas = arq.lerVendas();
        ArrayList<Venda> vendasMes = new ArrayList();
        
        for(int i = 0; i < todasVendas.size(); i++){
            if(todasVendas.get(i).getDataVenda().getMonthValue() == mes){
                vendasMes.add(todasVendas.get(i));
            }
        }
        return vendasMes;
    }    
    
    public ArrayList<Aluguel> listaTodosAluguelMes(int mes){
        mes++;
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todasAluguel = arq.lerAlugueis();
        ArrayList<Aluguel> AlugueisMes = new ArrayList();

        for(int i = 0; i < todasAluguel.size(); i++){
            if(todasAluguel.get(i).getDataAluguel().getMonthValue() == mes){
                AlugueisMes.add(todasAluguel.get(i));
            }
        }
        return AlugueisMes;
    }  
    
    
    
    //24. Listar todos os tipos de Seguros cadastrados.
    public ArrayList<Seguro> listaTodosSeguros(){
        IOArquivos arq = new IOArquivos();
        return arq.lerSeguros();
    }
    

    public ArrayList<Corretor> getTodosCOrretores(){
        IOArquivos arq = new IOArquivos(); 
        return arq.lerCorretores();
    }


    
    
    
    //Buscas de cliente/corretor/imovel/seguro Especifico
    public Cliente buscaClientePorCodigo(int codigo){
        IOArquivos arq = new IOArquivos();
        ArrayList<Cliente> todosClientes = arq.lerClientes();
        if(todosClientes == null){
            JOptionPane.showMessageDialog(null, "Ainda não existem Clientes Cadastrados!");
        }else {
            for(int i = 0; i < todosClientes.size(); i++){
                if (todosClientes.get(i).getCodigoUsuario() == codigo){
                    return todosClientes.get(i);
                }
            }
        }
        return null;
    }
    
    public Seguro buscaSeguroPorCodigo(int codigo){
        IOArquivos arq = new IOArquivos();
        ArrayList<Seguro> todosSeguros = arq.lerSeguros();
        if(todosSeguros == null){
            JOptionPane.showMessageDialog(null, "Ainda não existem Clientes Cadastrados!");
        }else {
            for(int i = 0; i < todosSeguros.size(); i++){
                if (todosSeguros.get(i).getCodigoSeguro()== codigo){
                    return todosSeguros.get(i);
                }
            }
        }
        return null;
    }
    
    public Corretor buscaCorretorPorCodigo(int codigo){
        IOArquivos arq = new IOArquivos();
        ArrayList<Corretor> todosCorretores = arq.lerCorretores();
        if(todosCorretores == null){
            JOptionPane.showMessageDialog(null, "Ainda não existem Corretores Cadastrados!");
        }else {
            for(int i = 0; i < todosCorretores.size(); i++){
                if (todosCorretores.get(i).getCodigoUsuario() == codigo){
                    return todosCorretores.get(i);
                }
            }
        }
        return null;
    }   
    
    public Imovel buscaImovelPorCodigo(int codigo){
        IOArquivos arq = new IOArquivos();
        ArrayList<Imovel> todosImoveis = arq.lerImoveis();
        if(todosImoveis == null){
            JOptionPane.showMessageDialog(null, "Ainda não existem Imoveis Cadastrados!");
        }else {
            for(int i = 0; i < todosImoveis.size(); i++){
                if (todosImoveis.get(i).getCodigoImovel() == codigo){
                    return todosImoveis.get(i);
                }
            }
        }
        return null;
    }  
    
        public Aluguel buscaAluguelPorCodigo(int codigo){
        IOArquivos arq = new IOArquivos();
        ArrayList<Aluguel> todosAlugueis = arq.lerAlugueis();
        if(todosAlugueis == null){
            JOptionPane.showMessageDialog(null, "Ainda não existem Alugueis Cadastrados!");
        }else {
            for(int i = 0; i < todosAlugueis.size(); i++){
                if (todosAlugueis.get(i).getCodigoAluguel()== codigo){
                    return todosAlugueis.get(i);
                }
            }
        }
        return null;
    } 
        
    public Venda buscaAVendaPorCodigo(int codigo){
        IOArquivos arq = new IOArquivos();
        ArrayList<Venda> todasVendas = arq.lerVendas();
        if(todasVendas == null){
            JOptionPane.showMessageDialog(null, "Ainda não existem Vendas Cadastrados!");
        }else {
            for(int i = 0; i < todasVendas.size(); i++){
                if (todasVendas.get(i).getCodigoVenda()== codigo){
                    return todasVendas.get(i);
                }
            }
        }
        return null;
    }    
    
}
    

    


    

