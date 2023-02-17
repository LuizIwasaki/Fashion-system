/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Roupa;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleRoupa {

    public ControleRoupa() {
    }
    
    public EntityManager getEntityManager()
    {
        return util.FabricaEntidades.getGerenteEntidade();
    }
    
    public void salvar(Roupa r)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();
        
        gerente.getTransaction().begin();
        
        gerente.persist(r);
        
        gerente.getTransaction().commit();

        gerente.close();
        
    }
    
    public void alterar(Roupa r)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        gerente.getTransaction().begin();
        
        gerente.merge(r);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }

    public void excluir(Roupa r)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        r = gerente.find(Roupa.class, r.getId());
        
        gerente.getTransaction().begin();
        
        gerente.remove(r);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }
    
    public List<Roupa> listarTodos()
    {
        List<Roupa> listaRoupas;
        
        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();
        
        TypedQuery<Roupa> consultaRoupa;
        
        consultaRoupa = Gerente.createNamedQuery("Roupa.listarTodos", Roupa.class);
        
        listaRoupas = consultaRoupa.getResultList();
                
        return listaRoupas;
    }
    
    public List<Roupa> listarPorNomePesquisado(String nomePesquisado)
    {
        List<Roupa> listaRoupas;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Roupa> consultaRoupa;
       
        consultaRoupa = Gerente.createNamedQuery("Roupa.listarPorNomePesquisado", Roupa.class);

        consultaRoupa.setParameter("nomePesquisa", "%"+nomePesquisado+"%");

        listaRoupas = consultaRoupa.getResultList();

        return listaRoupas;
    }
    
    public Roupa buscaPorCodigo(int codigo)
    {
        List<Roupa> listaRoupas;
        Roupa roupaEncontrada = null;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Roupa> consultaRoupa;
       
        consultaRoupa = Gerente.createNamedQuery("Roupa.buscaPorCodigoBarras", Roupa.class);

        consultaRoupa.setParameter("codigoBarras", codigo);

        listaRoupas = consultaRoupa.getResultList();

        if(!listaRoupas.isEmpty()){
            roupaEncontrada = listaRoupas.get(0);
        }
        
        return roupaEncontrada;
    }
}
