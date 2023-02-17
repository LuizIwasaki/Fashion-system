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
import modelo.Compra;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleCompra {

    public ControleCompra() {
    }
    
    public void salvar(Compra c) {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();

        gerente.getTransaction().begin();

        gerente.persist(c);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Compra c) {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;

        gerente.getTransaction().begin();

        gerente.merge(c);

        gerente.getTransaction().commit();

        gerente.close();

    }

    public List<Compra> listarTodos() {
        List<Compra> listaCompras;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Compra> consultaCompra;

        consultaCompra = Gerente.createNamedQuery("Compra.findAll", Compra.class);

        listaCompras = consultaCompra.getResultList();

        return listaCompras;
    }

    public List<Compra> listarPorData(Date data) {
        List<Compra> listaCompras;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Compra> consultaCompra;

        consultaCompra = Gerente.createNamedQuery("Compra.findByDataCompra", Compra.class);

        consultaCompra.setParameter("dataPesquisa", data);

        listaCompras = consultaCompra.getResultList();

        return listaCompras;
    }

    public List<Compra> listarPorFornecedor(long idFornecedor) {
        List<Compra> listaCompras;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Compra> consultaCompra;

        consultaCompra = Gerente.createNamedQuery("Compra.listaPorFornecedor", Compra.class);

        consultaCompra.setParameter("idFornecedor", idFornecedor);

        listaCompras = consultaCompra.getResultList();

        return listaCompras;
    }

    public static Compra buscaPorCodigo(int codigo) {
        List<Compra> lista;
        Compra encontrada = null;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Compra> consulta;

        consulta = Gerente.createNamedQuery("Compra.findByNotaFiscal", Compra.class);

        consulta.setParameter("notaFiscal", codigo);

        lista = consulta.getResultList();

        if (!lista.isEmpty()) {
            encontrada = lista.get(0);
        }

        return encontrada;
    }
}
