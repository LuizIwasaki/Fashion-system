/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Fornecedor;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleFornecedor {
    
    public ControleFornecedor() {
    }
    
    public void salvar(Fornecedor f)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();
        
        gerente.getTransaction().begin();
        
        gerente.persist(f);
        
        gerente.getTransaction().commit();

        gerente.close();
        
    }
    
    public void alterar(Fornecedor f)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        gerente.getTransaction().begin();
        
        gerente.merge(f);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }

    public void excluir(Fornecedor f)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        f = gerente.find(Fornecedor.class, f.getId());
        
        gerente.getTransaction().begin();
        
        gerente.remove(f);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }
    
    public List<Fornecedor> listarTodos()
    {
        List<Fornecedor> listaFornecedores;
        
        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();
        
        TypedQuery<Fornecedor> consultaFornecedor;
        
        consultaFornecedor = Gerente.createNamedQuery("Fornecedor.listarTodos", Fornecedor.class);
        
        listaFornecedores = consultaFornecedor.getResultList();
                
        return listaFornecedores;
    }
    
    public List<Fornecedor> listarPorNomePesquisado(String nomePesquisado)
    {
        List<Fornecedor> listaFornecedores;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Fornecedor> consultaFornecedor;
       
        consultaFornecedor = Gerente.createNamedQuery("Fornecedor.listarPorNomePesquisado", Fornecedor.class);

        consultaFornecedor.setParameter("nomePesquisa", nomePesquisado+"%");

        listaFornecedores = consultaFornecedor.getResultList();

        return listaFornecedores;
    }
    
    public static Fornecedor buscaCpfCnpj(String CpfCnpj)
    {
        Fornecedor f = null;
        List<Fornecedor> listaFornecedores;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Fornecedor> consultaFornecedor;
       
        consultaFornecedor = Gerente.createNamedQuery("Fornecedor.buscaPorCpfCnpj", Fornecedor.class);

        consultaFornecedor.setParameter("CpfCnPj", CpfCnpj);

        listaFornecedores = consultaFornecedor.getResultList();

        if(!listaFornecedores.isEmpty()){
            f = listaFornecedores.get(0);
        }
        
        return f;
    }
}
