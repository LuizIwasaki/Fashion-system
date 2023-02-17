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
import modelo.Despesa;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleDespesa {

    public ControleDespesa() {
    }
    
    public void salvar(Despesa d)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();
        
        gerente.getTransaction().begin();
        
        gerente.persist(d);
        
        gerente.getTransaction().commit();

        gerente.close();
        
    }
    
    public void alterar(Despesa d)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        gerente.getTransaction().begin();
        
        gerente.merge(d);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }

    public void excluir(Despesa d)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        d = gerente.find(Despesa.class, d.getId());
        
        gerente.getTransaction().begin();
        
        gerente.remove(d);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }
    
    public List<Despesa> listarTodos()
    {
        List<Despesa> listaDespesas;
        
        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();
        
        TypedQuery<Despesa> consultaDespesa;
        
        consultaDespesa = Gerente.createNamedQuery("Despesa.listarTodos", Despesa.class);
        
        listaDespesas = consultaDespesa.getResultList();
                
        return listaDespesas;
    }
    
    public List<Despesa> listarPorDescricao(String descricao)
    {
        List<Despesa> listaDespesas;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Despesa> consultaDespesa;
       
        consultaDespesa = Gerente.createNamedQuery("Despesa.listarPorDescricao", Despesa.class);

        consultaDespesa.setParameter("descricaoPesquisa", descricao+"%");

        listaDespesas = consultaDespesa.getResultList();

        return listaDespesas;
    }
    
    public List<Despesa> listarPorNomePesquisado(Date data)
    {
        List<Despesa> listaDespesas;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Despesa> consultaDespesa;
       
        consultaDespesa = Gerente.createNamedQuery("Despesa.listarPorData", Despesa.class);

        consultaDespesa.setParameter("dataPesquisa", data);

        listaDespesas = consultaDespesa.getResultList();

        return listaDespesas;
    }
}
