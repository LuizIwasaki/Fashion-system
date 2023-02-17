/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Venda;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleVenda {

    public ControleVenda() {
    }

    public void salvar(Venda v) {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();

        gerente.getTransaction().begin();

        gerente.persist(v);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Venda v) {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;

        gerente.getTransaction().begin();

        gerente.merge(v);

        gerente.getTransaction().commit();

        gerente.close();

    }

    public List<Venda> listarTodos() {
        List<Venda> listaVendas;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Venda> consultaVenda;

        consultaVenda = Gerente.createNamedQuery("Venda.findAll", Venda.class);

        listaVendas = consultaVenda.getResultList();

        return listaVendas;
    }
    
    public List<Venda> listarPorData(Date data)
    {
        List<Venda> listaVendas;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Venda> consultaVenda;
       
        consultaVenda = Gerente.createNamedQuery("Venda.findByDataVenda", Venda.class);

        consultaVenda.setParameter("dataPesquisa", data);

        listaVendas = consultaVenda.getResultList();

        return listaVendas;
    }
    
    public List<Venda> listarPorCliente(long idCliente)
    {
        List<Venda> listaVendas;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Venda> consultaVenda;
       
        consultaVenda = Gerente.createNamedQuery("Venda.listaPorCliente", Venda.class);

        consultaVenda.setParameter("idCliente", idCliente);

        listaVendas = consultaVenda.getResultList();

        return listaVendas;
    }
    
    public List<Venda> listarPorClienteN(long idCliente)
    {
        List<Venda> listaVendas;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Venda> consultaVenda;
       
        consultaVenda = Gerente.createNamedQuery("Venda.listaPorClienteN", Venda.class);

        consultaVenda.setParameter("idCliente", idCliente);

        listaVendas = consultaVenda.getResultList();

        return listaVendas;
    }

    public static Venda buscaPorCodigo(int codigo)
    {
        List<Venda> lista;
        Venda encontrada = null;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Venda> consulta;
       
        consulta = Gerente.createNamedQuery("Venda.findByNotaFiscal", Venda.class);

        consulta.setParameter("notaFiscal", codigo);

        lista = consulta.getResultList();

        if(!lista.isEmpty()){
            encontrada = lista.get(0);
        }
        
        return encontrada;
    }
    
}
