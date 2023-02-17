/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Caixa;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleCaixa {

    public ControleCaixa() {
    }
    
    public EntityManager getEntityManager()
    {
        return util.FabricaEntidades.getGerenteEntidade();
    }
    
    private static Caixa caixaAberto;

    public static Caixa getCaixaAberto() {
        return caixaAberto;
    }

    public static void setCaixaAberto(Caixa caixaAberto) {
        ControleCaixa.caixaAberto = caixaAberto;
    }
    
    public static boolean isCaixaAberto() {
        return caixaAberto != null;
    }
    
    public static void atualizaCaixa(){
        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Caixa> consulta;
       
        consulta = Gerente.createNamedQuery("Caixa.findId", Caixa.class);

        consulta.setParameter("idCaixa", caixaAberto.getId());

        caixaAberto = consulta.getSingleResult();
    }
    
    public void salvar(Caixa c)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();
        
        gerente.getTransaction().begin();
        
        gerente.persist(c);
        
        gerente.getTransaction().commit();

        gerente.close();
        
    }
    
    public void alterar(Caixa c)
    {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;
        
        gerente.getTransaction().begin();
        
        gerente.merge(c);
        
        gerente.getTransaction().commit();
        
        gerente.close();
        
    }
    
    public List<Caixa> listarTodos()
    {
        List<Caixa> listaCaixas;
        
        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();
        
        TypedQuery<Caixa> consultaCaixa;
        
        consultaCaixa = Gerente.createNamedQuery("Caixa.findAll", Caixa.class);
        
        listaCaixas = consultaCaixa.getResultList();
                
        return listaCaixas;
    }
    
}
