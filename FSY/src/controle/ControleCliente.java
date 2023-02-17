/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Cliente;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleCliente {
    
    public ControleCliente() {
    }
    
    public void salvar(Cliente c)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();
        
        gerente.getTransaction().begin();
        
        gerente.persist(c);
        
        gerente.getTransaction().commit();

        gerente.close();
        
    }
    
    public void alterar(Cliente c)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        gerente.getTransaction().begin();
        
        gerente.merge(c);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }

    public void excluir(Cliente c)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        c = gerente.find(Cliente.class, c.getId());
        
        gerente.getTransaction().begin();
        
        gerente.remove(c);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }
    
    public List<Cliente> listarTodos()
    {
        List<Cliente> listaClientes;
        
        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();
        
        TypedQuery<Cliente> consultaCliente;
        
        consultaCliente = Gerente.createNamedQuery("Cliente.listarTodos", Cliente.class);
        
        listaClientes = consultaCliente.getResultList();
                
        return listaClientes;
    }
    
    public List<Cliente> listarPorNomePesquisado(String nomePesquisado)
    {
        List<Cliente> listaClientes;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Cliente> consultaCliente;
       
        consultaCliente = Gerente.createNamedQuery("Cliente.listarPorNomePesquisado", Cliente.class);

        consultaCliente.setParameter("nomePesquisa", "%"+nomePesquisado+"%");

        listaClientes = consultaCliente.getResultList();

        return listaClientes;
    }
    
    public boolean cpfExistente(String Cpf)
    {
        boolean existe = false;
        List<Cliente> listaClientes;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Cliente> consultaCliente;
       
        consultaCliente = Gerente.createNamedQuery("Cliente.buscaPorCpf", Cliente.class);

        consultaCliente.setParameter("Cpf", Cpf);

        listaClientes = consultaCliente.getResultList();

        if(!listaClientes.isEmpty()){
            existe = true;
        }
        
        return existe;
    }
    
    public Cliente buscaCPF(String Cpf)
    {
        List<Cliente> listaClientes;
        Cliente clienteEncontrado = null;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Cliente> consultaCliente;
       
        consultaCliente = Gerente.createNamedQuery("Cliente.buscaPorCpf", Cliente.class);

        consultaCliente.setParameter("Cpf", Cpf);

        listaClientes = consultaCliente.getResultList();

        if(!listaClientes.isEmpty()){
            clienteEncontrado = listaClientes.get(0);
        }
        
        return clienteEncontrado;
    }
}
