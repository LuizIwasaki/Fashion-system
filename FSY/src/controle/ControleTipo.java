/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.TipoRoupa;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleTipo {

    public ControleTipo() {
    }
    
    public void salvar(TipoRoupa t)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();
        
        gerente.getTransaction().begin();
        
        gerente.persist(t);
        
        gerente.getTransaction().commit();
        
        gerente.close();
    }
    
    public void alterar(TipoRoupa t)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();
        
        gerente.getTransaction().begin();
        
        gerente.merge(t);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }

    public void excluir(TipoRoupa t)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        t = gerente.find(TipoRoupa.class, t.getId());
        
        gerente.getTransaction().begin();
        
        gerente.remove(t);
        
        gerente.getTransaction().commit();
       
        gerente.close();
        
    }
    
    public List<TipoRoupa> listarTodos()
    {
        List<TipoRoupa> listaTipos;
        
        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();
        
        TypedQuery<TipoRoupa> consultaTipo;
        
        consultaTipo = Gerente.createNamedQuery("TipoRoupa.listarTodos", TipoRoupa.class);
        
        listaTipos = consultaTipo.getResultList();
                
        return listaTipos;
    }
    
    public List<TipoRoupa> listarPorNomePesquisado(String nomePesquisado)
    {
        List<TipoRoupa> listaTipos;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<TipoRoupa> consultaTipo;
       
        consultaTipo = Gerente.createNamedQuery("TipoRoupa.listarPorNome", TipoRoupa.class);

        consultaTipo.setParameter("nomePesquisa", "%"+nomePesquisado+"%");

        listaTipos = consultaTipo.getResultList();

        return listaTipos;
    }
    
    public boolean tipoInexistente(String nome)
    {
        boolean naoAchou = false;
        List<TipoRoupa> listaTipos;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<TipoRoupa> consultaTipo;
       
        consultaTipo = Gerente.createNamedQuery("TipoRoupa.existente", TipoRoupa.class);

        consultaTipo.setParameter("nomePesquisa", nome);

        listaTipos = consultaTipo.getResultList();

        if(listaTipos.isEmpty()){
            naoAchou = true;
        }
        
        return naoAchou;
    }
}
